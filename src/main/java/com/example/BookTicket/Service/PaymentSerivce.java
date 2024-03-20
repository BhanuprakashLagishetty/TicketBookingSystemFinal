package com.example.BookTicket.Service;

import com.example.BookTicket.Converting.AllConversions;
import com.example.BookTicket.Entity.Booking;
import com.example.BookTicket.Entity.BookingDate;
import com.example.BookTicket.Entity.Payment;
import com.example.BookTicket.Entity.Seat;
import com.example.BookTicket.Models.BookingModel;
import com.example.BookTicket.Models.PaymentModel;
import com.example.BookTicket.Repository.booking_Repo;
import com.example.BookTicket.Repository.payment_Repo;
import com.example.BookTicket.Repository.user_Repo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class PaymentSerivce {
    @Autowired
    private payment_Repo paymentRepo;
    @Autowired
    private AllConversions allConversions;

    @Autowired
    private booking_Repo bookingRepo;

    @Autowired
    private user_Repo userRepo;

    public BookingModel ticketsPayments(PaymentModel paymentModel, Long bookId, LocalDate bookingDate)
    {
        try{

            Booking booking=bookingRepo.findById(bookId).orElse(null);
            Payment payment=booking.getPayment();
            PaymentModel paymentModel1=allConversions.paymentToPaymentModel(payment);
            if(paymentModel1.getAmount()==paymentModel.getAmount() && booking.getUser().getBalance()>=paymentModel.getAmount())
            {
                if(paymentModel1.getPaymentStatus().equals("completed"))
                {
                    return new BookingModel();
                }
                booking.getUser().setBalance(booking.getUser().getBalance()-paymentModel.getAmount());
                paymentModel1.setPaymentStatus("completed");
                booking.setBookingStatus("completed");

                //updating the seat to booked
                Set<Seat> seatSet=booking.getSeats();
                System.out.println(seatSet.size());
                seatSet.forEach((e)->{
                    List<BookingDate>bookingDateList=e.getBookingDates();
                    BookingDate bookingDate1=new BookingDate();
                    bookingDate1.setBookingDate(bookingDate);
                    bookingDate1.setSeat(e);
                    e.setSeatStatus("conformed");
                    bookingDateList.add(bookingDate1);
                });
                bookingRepo.save(booking);
                Payment payment1=allConversions.paymentModelToPayment(paymentModel1);
                paymentRepo.save(payment1);
                BookingModel bookingModel=new BookingModel();
                BeanUtils.copyProperties(booking,bookingModel);
                System.out.println(bookingModel);
                return bookingModel;
            }
            else{
                BookingModel bookingModel=new BookingModel();
                bookingModel.setResult("insufficent Balance");
                return bookingModel;
            }
        }
        catch (Exception e)
        {
            BookingModel bookingModel=new BookingModel();
            bookingModel.setResult("invalid booking Id");
            return bookingModel;
        }

    }
}
