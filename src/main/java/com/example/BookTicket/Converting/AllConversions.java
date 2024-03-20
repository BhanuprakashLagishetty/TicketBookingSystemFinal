package com.example.BookTicket.Converting;

import com.example.BookTicket.Entity.*;
import com.example.BookTicket.Models.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AllConversions {
    @Autowired
    PasswordEncoder passwordEncoder;

    public Booking bookingModelToBooking(BookingModel bookingModel) {
        if(bookingModel==null){
            return null;
        }
        Booking booking=new Booking();
        booking.setId(bookingModel.getId());
        booking.setUser(bookingModel.getUser());
        booking.setBookedDate(bookingModel.getBookedDate());
        booking.setBookingStatus(bookingModel.getBookingStatus());
        booking.setBookingTime(bookingModel.getBookingTime());
        booking.setBookingType(bookingModel.getBookingType());
        booking.setArrivalStation(bookingModel.getArrivalStation());
        booking.setDestinationStation(bookingModel.getDestinationStation());
        booking.setNumerOfSeats(bookingModel.getNumerOfSeats());
        booking.setPayment(bookingModel.getPayment());
        booking.setPrice(bookingModel.getPrice());
        booking.setSeats(bookingModel.getSeats());
        booking.setWaitingLists(bookingModel.getWaitingLists());
        booking.setTickets(bookingModel.getTickets());
        return booking;

    }

    public Train trainModelToEntity(TrainModel trainModel) {
        Train train = new Train();
        train.setId(trainModel.getId());
        train.setName(trainModel.getName());
        train.setNumber(trainModel.getNumber());
        train.setArrivalTime(trainModel.getArrivalTime());
        train.setDepartureTime(trainModel.getDepartureTime());
        train.setArrivalStation(trainModel.getArrivalStation());
        train.setDepartureStation(trainModel.getDepartureStation());
        train.setTrain_Passangers(trainModel.getTrain_PassangersModel());
        train.setSeats(trainModel.getSeats());
        System.out.println(trainModel.getDays());
        train.setDays(trainModel.getDays());
        train.setAvailableSeats(trainModel.getAvailableSeats());
        return train;

    }
    public TrainModel trainToTrainModel(Train train) {
        TrainModel trainModel = new TrainModel();
        trainModel.setId(train.getId());
        trainModel.setName(train.getName());
        trainModel.setDays(train.getDays());
        trainModel.setNumber(train.getNumber());
        trainModel.setArrivalTime(train.getArrivalTime());
        trainModel.setArrivalStation(train.getArrivalStation());
        trainModel.setTrain_PassangersModel(train.getTrain_Passangers());
        trainModel.setArrivalStation(train.getArrivalStation());
        trainModel.setDepartureStation(train.getDepartureStation());
        trainModel.setDepartureTime(train.getDepartureTime());
        trainModel.setSeats(train.getSeats());
        trainModel.setAvailableSeats(train.getAvailableSeats());
        trainModel.setStations(train.getStations());
        return trainModel;

    }
    public User userModelToUser(UserModel userModel)
    {
        User user=new User();
        user.setUsername(userModel.getUserName());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setEmail(userModel.getEmail());
        user.setBooking(userModel.getBookingModel());
        user.setAge(userModel.getAge());
        user.setTrain(userModel.getTrain());
        user.setBalance(userModel.getBalance());
        user.setTrain(userModel.getTrain());
        user.setBalance(userModel.getBalance());
        return user;

    }
    public BookingModel bookingToBookingModel(Booking booking) {

        BookingModel bookingModel=new BookingModel();
        bookingModel.setId(booking.getId());
        bookingModel.setUser(booking.getUser());
        bookingModel.setBookingType(booking.getBookingType());
        bookingModel.setBookedDate(booking.getBookedDate());
        bookingModel.setBookingStatus(booking.getBookingStatus());
        bookingModel.setDestinationStation(booking.getDestinationStation());
        bookingModel.setArrivalStation(booking.getArrivalStation());
        bookingModel.setPrice(booking.getPrice());
        bookingModel.setSeats(booking.getSeats());
        bookingModel.setNumerOfSeats(booking.getNumerOfSeats());
        bookingModel.setPayment(booking.getPayment());
        bookingModel.setBookingTime(booking.getBookingTime());
        bookingModel.setTickets(booking.getTickets());
        bookingModel.setWaitingLists(booking.getWaitingLists());

        return bookingModel;


    }

    public PaymentModel paymentToPaymentModel(Payment payment)
    {
        PaymentModel paymentModel=new PaymentModel();
        paymentModel.setPaymentStatus(payment.getPaymentStatus());
        paymentModel.setId(payment.getId());
        paymentModel.setBooking(payment.getBooking());
        paymentModel.setAmount(payment.getAmount());
        return paymentModel;

    }
    public Payment paymentModelToPayment(PaymentModel paymentModel)
    {
        Payment payment=new Payment();
        payment.setAmount(paymentModel.getAmount());
        payment.setBooking(paymentModel.getBooking());
        payment.setPaymentStatus(paymentModel.getPaymentStatus());
        payment.setId(paymentModel.getId());
        return payment;
    }
    public Seat seatModelToSeat(SeatsModel seatsModel)
    {
        Seat seat=new Seat();
        seat.setTrain(seatsModel.getTrain());
        seat.setSeatNumber(seatsModel.getSeatNumber());
        seat.setAvailable(seatsModel.isAvailable());
        seat.setBookingSeats(seatsModel.getBookingSeats());
        seat.setTypeOfSeat(seatsModel.getTypeOfSeat());
        return seat;
    }
    public SeatsModel seatToSeatModel(Seat seat)
    {
        SeatsModel seatModel=new SeatsModel();
        seatModel.setSeatNumber(seat.getSeatNumber());
        seatModel.setTypeOfSeat(seat.getTypeOfSeat());
        seatModel.setAvailable(seat.isAvailable());
        seatModel.setTrain(seat.getTrain());
        seatModel.setBookingSeats(seat.getBookingSeats());
        return seatModel;
    }
}
