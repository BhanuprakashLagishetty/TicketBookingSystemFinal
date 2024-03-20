package com.example.BookTicket.Models;

import com.example.BookTicket.Entity.Booking;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class TicketModel {
    private Long id;
    private String mode;
    private String passangerName;
    private String age;
    private String Gender;
    private Long seatNumber;
    private String departureLocation;
    private String arrivalLocation;
    private BigDecimal price;
    private Booking booking;
}
