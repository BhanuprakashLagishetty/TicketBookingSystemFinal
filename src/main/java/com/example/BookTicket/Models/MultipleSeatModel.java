package com.example.BookTicket.Models;

import com.example.BookTicket.Entity.Seat;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class MultipleSeatModel {
    private Set<Seat>seatSet;
}
