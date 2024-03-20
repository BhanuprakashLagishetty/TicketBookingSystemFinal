package com.example.BookTicket.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class WaitingList {
    @Id
    @GeneratedValue
    private Long seatNumber;
    private String typeOfSeat;
    private Long confirmedSeat;

    private boolean available;
    private LocalDate bookedDate;
    @ManyToOne
    @JoinColumn(name = "train_id")
    @JsonIgnore
    private Train train;
    private String status;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnore
    private Booking bookingSeats;

    @OneToMany(mappedBy = "waitingList", cascade =  CascadeType.MERGE)
//    @JsonManagedReference
    private List<BookingDate> bookingDates = new ArrayList<>();
}
