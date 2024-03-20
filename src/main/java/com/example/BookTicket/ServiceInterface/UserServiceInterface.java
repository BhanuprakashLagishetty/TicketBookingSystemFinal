package com.example.BookTicket.ServiceInterface;

import com.example.BookTicket.Entity.*;
import com.example.BookTicket.Models.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface UserServiceInterface {
    BookingModel bookingTickets(BookingModel bookingModel, Long userId, Long trainId, PriceGenerationModel priceGenerationModel);

    BookingModel createBookingModel(BookingModel bookingModel, int numberOfSeats, double price, PriceGenerationModel priceGenerationModel);

    BookingModel createBooking(BookingModel bookingModel);

    User addUser(UserModel userModel);

    BookingModel convertseatNumbersToBookingModel(Set<String> selectedSeatNumbers, Long user_Id, Long Train_Id, PriceGenerationModel priceGenerationModel, LocalDate bookedDate);

    long checklogin(UserModel userModel);

    List<Booking> findBookingHistory(Long userId);

    BookingModel cancelBooking(Long bookingId);

    void UpdatingBalance(Booking booking);

    Boolean validateTime(Booking booking);

    Set<Seat> displayBookingSeats(Long bookingId);

    BookingModel bookWatingListTickets(int numberOfSeats, String typeOfSeat, Long gUserId, Long gTrainId, LocalDate gBookingDate, PriceGenerationModel priceGenerationModel1);

    void CreateWaitingList(LocalDate gBookingDate, Train train, String typeOfSeat, Set<WaitingList> waitingListSet);

    BookingModel createWaitingList(BookingModel bookingModel);

    void changingWaitingListStatus(BookingDate bookingDate, Seat seat);

    List<WaitingList> allWaitingListTickets(Long gUserId);

    boolean validateBookingDate(LocalDate BookingDate);

    double showBalance(Long gUserId);

    double recharge(Long gUserId, int balance);

    Set<SeatsModel> DisplayTrainTickets(Long trainId, LocalDate bookingDate);

    List<TrainModel> displayTrainOnLocations(String arrivalLocation, String departureLocation, LocalDate bookingDate);
}
