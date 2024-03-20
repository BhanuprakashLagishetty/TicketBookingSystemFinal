package com.example.BookTicket.Controller;

//import com.example.BookTicket.Models.SeatsModel;
import com.example.BookTicket.Entity.Stations;
import com.example.BookTicket.Models.SeatsModel;
import com.example.BookTicket.Models.TrainModel;
import com.example.BookTicket.Service.AdminService;
import com.example.BookTicket.validator.TrainValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    private long G_TrainId;

    @Autowired
    private TrainValidator trainValidator;

    @RequestMapping("/saveTrain")
    public String saveTrain()
    {

        return "addTrain";
    }
    @RequestMapping("/addTrain")
    public String addTrain(@ModelAttribute("TrainModel") TrainModel trainModel, Model model, BindingResult bindingResult)
    {
        trainValidator.validate(trainModel,bindingResult);
        System.out.println(bindingResult);
        if(bindingResult.hasErrors())
        {
            System.out.println("bhanu");
            return "addTrain";
        }
        String res= adminService.addTrain(trainModel);
        return "redirect:/DisplayAllTrains";
    }
    @RequestMapping("/removeTrain")
    public String removeTrain(@RequestParam("trainId")Long trainId)
    {

        adminService.removeTrain(trainId);
        return "redirect:/DisplayAllTrains";
    }

    @RequestMapping("/DisplayAllTrains")
    public Object displayAllTrains(Model model)
    {
        List<TrainModel>trainModelList=adminService.displayAllTrains();
        if(!trainModelList.isEmpty())
        {
            model.addAttribute("Train",trainModelList);

            return trainModelList;
        }
        return "no reacords found";
    }
    @RequestMapping("/AddingTicketsToTrain")
    public Object AddingTicketsToTrain(SeatsModel seatsModel)
    {
        seatsModel.setAvailable(true);
        adminService.addingTicketsToTrain(G_TrainId,seatsModel);
        return "redirect:/DisplayadminTrainTickets?trainId="+G_TrainId;
    }
    @RequestMapping("/AddingStationsToTrain")
    public Object AddingStationsToTrain (Stations stations)
    {

        adminService.addingStationsToTrain(G_TrainId,stations);
        return "redirect:/DisplayIntermediateStations?trainId="+G_TrainId;
    }


    @RequestMapping("AddingSeats")
    public String AddingTickets(int trainId)
    {
        G_TrainId=trainId;
        return "AddTickents";
    }

    @RequestMapping("/DisplayIntermediateStations")
    public String DisplayIntermediateStations(Model model,Long trainId)
    {
        G_TrainId=trainId;

        Set<Stations>stations=adminService.DisplayIntermediateStations(G_TrainId);
        model.addAttribute("stations",stations);
        return "DisplayStations";

    }
    @RequestMapping("/AddStations")
    public String AddStations()
    {
        return "AddStations";
    }

    @RequestMapping("/DisplayadminTrainTickets")
    public String DisplayTrainTickets(Long trainId, Model model){
        G_TrainId=trainId;
        Set<SeatsModel>seatsModelSet = adminService.displayTrainTickets(trainId);
        model.addAttribute("seatList",seatsModelSet);
        model.addAttribute("trainId",trainId);
        return "displayAdminAllTrainSeats";
    }
}
