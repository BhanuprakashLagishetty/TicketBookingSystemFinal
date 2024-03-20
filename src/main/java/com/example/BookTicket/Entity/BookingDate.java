package com.example.BookTicket.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class BookingDate {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    @JsonIgnore
    private Seat seat;

    @Override
    public String toString() {
        return "BookingDate{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", seat=" + seat +
                ", waitingList=" + waitingList +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "watingList_id")
    @JsonIgnore
    private WaitingList waitingList;



}
