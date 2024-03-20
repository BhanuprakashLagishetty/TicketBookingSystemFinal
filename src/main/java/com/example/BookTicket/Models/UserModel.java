package com.example.BookTicket.Models;

import com.example.BookTicket.Entity.Booking;
import com.example.BookTicket.Entity.Train;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UserModel {
    private String userName;
    private String password;
    private int age;
    private String email;
    private double balance;
    private List<Booking> bookingModel = new ArrayList<>();
    private Set<Train> train = new HashSet<>();

}
