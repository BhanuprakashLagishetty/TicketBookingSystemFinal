package com.example.BookTicket.Models;

import com.example.BookTicket.Entity.User;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class BusModel {
    private String operator;
    private String departureLocation;
    private String arrivalLocation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int seactingCapacity;
    private Set<UserModel>bus_passagesModel = new HashSet<>();

}
