package com.example.BookTicket.Models;

import com.example.BookTicket.Entity.Booking;
import com.example.BookTicket.Entity.Train;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatsModel {
    private Long seatNumber;
    private boolean isAvailable;
    private String seatStatus;
    private LocalDate bookedDate;
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private String typeOfSeat;
    private Train train;
    private Booking bookingSeats;

}
