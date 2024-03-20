package com.example.BookTicket.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String stationName;
    private int km;

    @ManyToOne
    @JoinColumn(name = "train_id")
    @JsonIgnore
    private Train train;
}
