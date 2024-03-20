package com.example.BookTicket.Models;

import com.example.BookTicket.Entity.Booking;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class PaymentModel {
    private Long id;
    private double amount;
    private String paymentStatus;
    private Booking booking;
}
