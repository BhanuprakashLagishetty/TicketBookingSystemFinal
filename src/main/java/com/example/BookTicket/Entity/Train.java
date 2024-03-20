package com.example.BookTicket.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String number;
    private String departureStation;
    private String arrivalStation;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    @ManyToMany(mappedBy = "train")
    private Set<User> train_Passangers = new HashSet<>();

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TrainRuns> days = new ArrayList<>();

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Seat> seats= new HashSet<>();
    private int availableSeats;

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Stations>stations= new HashSet<>();

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<WaitingList>watitingList= new HashSet<>();
}
