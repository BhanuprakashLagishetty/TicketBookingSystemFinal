package com.example.BookTicket.Models;

import com.example.BookTicket.Entity.Seat;
import com.example.BookTicket.Entity.Stations;
import com.example.BookTicket.Entity.TrainRuns;
import com.example.BookTicket.Entity.User;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor

public class TrainModel {
    private Long id;
    private String name;
    private String number;
    private String departureStation;
    private String arrivalStation;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int availableSeats;
    private Set<User> train_PassangersModel = new HashSet<>();
    private List<TrainRuns> days = new ArrayList<>();
    private Set<Seat> seats= new HashSet<>();
    private Set<Stations>stations= new HashSet<>();
}
