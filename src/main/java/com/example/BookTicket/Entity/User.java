package com.example.BookTicket.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private double balance=2000;
    private String role="ROLE_USER";
    private int age;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<Booking> booking = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "user_Trains",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "train_id"))
            private Set<Train> train = new HashSet<>();






}
