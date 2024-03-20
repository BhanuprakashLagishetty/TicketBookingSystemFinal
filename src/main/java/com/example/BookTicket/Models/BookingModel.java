package com.example.BookTicket.Models;

import com.example.BookTicket.Entity.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class BookingModel {
    private Long id;
    private User user;
    private int numerOfSeats;
    private double price;
    private String bookingStatus;
    private String arrivalStation;
    private String DestinationStation;
    private int Km;
    private LocalDateTime bookingTime;
    private LocalDate BookedDate;
    private String bookingType;
    private String result;
    private List<Ticket> tickets = new ArrayList<>();
    private Payment payment;
    private Set<Seat>seats = new HashSet<>();
    private Set<WaitingList>waitingLists=new HashSet<>();
}
