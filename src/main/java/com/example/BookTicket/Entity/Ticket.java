package com.example.BookTicket.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mode;
    private String passangerName;
    private String age;
    private String Gender;
    private Long seatNumber;
    private String departureLocation;
    private String arrivalLocation;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

}
