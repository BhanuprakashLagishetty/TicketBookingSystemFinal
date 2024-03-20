package com.example.BookTicket.Controller;

import com.example.BookTicket.Entity.Booking;
import com.example.BookTicket.Entity.Seat;
import com.example.BookTicket.Entity.User;
import com.example.BookTicket.Entity.WaitingList;
import com.example.BookTicket.Models.*;
import com.example.BookTicket.Service.AdminService;
import com.example.BookTicket.Service.PaymentSerivce;
import com.example.BookTicket.Service.UserService;
//import com.example.BookTicket.validator.SearchTrainValidator;
import com.example.BookTicket.validator.SearchTrainValidator;
import com.example.BookTicket.validator.UserValidator;
import com.oracle.wls.shaded.org.apache.xpath.SourceTree;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    private Long g_userId;
    private Long g_TrainId;
    private LocalDate g_bookingDate;
    @Autowired
    private UserService userService;

    @Autowired
    private SearchTrainValidator searchTrainValidator;
    @Autowired
    private AdminService adminService;
    private PriceGenerationModel priceGenerationModel1;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PaymentSerivce paymentSerivce;
    @RequestMapping("/bookingTickets")
    public Object bookingTickets(@RequestParam(value = "selectedSeats", required = false) Set<String> selectedSeatNumbers, LocalDate bookingDate, Model model) {
       BookingModel bookingModel1= userService.convertseatNumbersToBookingModel(selectedSeatNumbers, g_userId, g_TrainId,priceGenerationModel1, g_bookingDate);
        if(bookingModel1.getId()==null)
        {
            return "notfoundjsp";
        }
        model.addAttribute("bookingModel",bookingModel1);
        return "booking";
    }

    @RequestMapping("/loginUser")
    public String loginUser(UserModel userModel)
    {
        Long userId=userService.checklogin(userModel);

        if(userId!=0)
        {
            g_userId =userId;
            return "redirect:/searchTrain";
        }
        return "userLogin";
    }
    @RequestMapping("/searchTrain")
    public String searchTrain(){
        return "SearchingTrain";
    }


    @RequestMapping("/HistoryOfBooking")
    public String HistoryOfBooking(Model model)
    {
        List<Booking>bookingList=userService.findBookingHistory(g_userId);
        model.addAttribute(bookingList);
        return "showHistory";
    }
    @RequestMapping("/makePayment")
    public String ticketsPayments(Long bookingId ,double price,Model model)
    {
        model.addAttribute("bookingId",bookingId);
        model.addAttribute("price",price);
        return "payment";
    }
    @RequestMapping ("/ticketsPayments")
    public String ticketsPayments(PaymentModel paymentModel,Long bookingId,Model model)
    {
        BookingModel booking= paymentSerivce.ticketsPayments(paymentModel,bookingId, g_bookingDate);
        if(booking==null || booking.getResult()!=null)
        {
            model.addAttribute("result",booking.getResult());
            return "resultOfPayment";
        }
        model.addAttribute("bookingModel",booking);
        return "booking";

    }

    @RequestMapping("/SearchTrain")
    public String SearchTrain()
    {
        return "SearchTrains";
    }
    @RequestMapping("/Searching")
    public String Searching()
    {
        return "SearchingTrain";
    }

    @RequestMapping("/UserRegistration")
    public String UserRegistration()
    {
        return "UserRegistration";
    }
    @RequestMapping("/AddUser")
    public String AddUser(@Valid @ModelAttribute("UserModel")UserModel userModel, Model model, BindingResult bindingResult)
    {
        userValidator.validate(userModel,bindingResult);
        if(bindingResult.hasErrors())
        {
            return "UserRegistration";
        }
        User user=userService.addUser(userModel);
        if(user.getId()!=null)
        {
            g_userId =user.getId();
            return "SearchingTrain";
        }
        else {
            return "userAlreadyfound";
        }


    }
    @RequestMapping("/DisplayTrainTickets")
    public String DisplayTrainTickets(Long trainId,LocalDate bookingDate, Model model){
        g_TrainId =trainId;
        g_bookingDate =bookingDate;
        Set<SeatsModel>seatsModelSet = userService.DisplayTrainTickets(trainId,bookingDate);
        model.addAttribute("seatList",seatsModelSet);
        model.addAttribute("trainId",trainId);
        model.addAttribute("bookingDate",bookingDate);
        if(seatsModelSet.isEmpty())
        {
            return "waitingListTickets";
        }

        return "displayAllTrainSeats";
    }

    @RequestMapping("/payment")
    public String payment()
    {
        return "payment";
    }

    @RequestMapping("/findTrains")
    public String findTrains(@Valid @ModelAttribute("SearchTrainModel")SearchTrainModel searchTrainModel,Model model,BindingResult bindingResult)
    {
        System.out.println(searchTrainModel.getBookingDate());
        searchTrainValidator.validate(searchTrainModel,bindingResult);
        if(bindingResult.hasErrors())
        {
            return "redirect:/searchTrain";
        }


        if(!userService.validateBookingDate(searchTrainModel.getBookingDate())){
            return "BookedDateError";
        }
        List<TrainModel> trainModelList =userService.displayTrainOnLocations(searchTrainModel.getArrivalStation(),searchTrainModel.getDepartureStation(),searchTrainModel.getBookingDate());
        if(!trainModelList.isEmpty())
        {
            priceGenerationModel1= adminService.findKilometers(searchTrainModel.getArrivalStation(),searchTrainModel.getDepartureStation(),trainModelList);
        }
        model.addAttribute("bookingDate",searchTrainModel.getBookingDate());
        model.addAttribute("trainList",trainModelList);
        model.addAttribute("priceGenerationModel",priceGenerationModel1);
        return "DisplayResultantTrains";
    }

    @RequestMapping("/CancelBooking")
    public String CancelBooking(Long bookingId,Model model)
    {
        BookingModel bookingModel=userService.cancelBooking(bookingId);
        if(bookingModel==null || bookingModel.getId()==null)
        {
            return "ResultOfCancel";
        }
        model.addAttribute("bookingModel",bookingModel);
        return "CancelationResults";

    }

    @RequestMapping("/DisplayBookingSeats")
    public String displayBookingSeats(Long bookingId,Model model)
    {

       Set<Seat>seatSet= userService.displayBookingSeats(bookingId);
       model.addAttribute("seatList",seatSet);
       return "DisplaySeatSet";
    }

    @RequestMapping("/waitingListTickets")
    public String waitingListTickets(int numberOfSeats, String typeOfSeat, Model model)
    {
        BookingModel bookingModel=userService.bookWatingListTickets(numberOfSeats,typeOfSeat, g_userId, g_TrainId, g_bookingDate,priceGenerationModel1);
        model.addAttribute("bookingModel",bookingModel);
        return "booking";
    }

    @RequestMapping("/allWaitingListTickets")
    public String allWaitingListTickets(Model model)
    {
        List<WaitingList>waitingLists=userService.allWaitingListTickets(g_userId);
        model.addAttribute("seatList",waitingLists);
        return "displayWaitingListSeatStatus";
    }

    @RequestMapping("/showBankBalance")
    public String showBankBalance(Model model)
    {
        double price=userService.showBalance(g_userId);
        model.addAttribute("price",price);
        return "showBankBalance";
    }
    @RequestMapping("/Recharge")
    public String Recharge()
    {
        return "Recharging";

    }
    @RequestMapping("/Recharging")
    public String Recharging(int balance,Model model)
    {
        double price=userService.recharge(g_userId,balance);
        model.addAttribute("price",price);
        return "redirect:/showBankBalance";
    }

}
