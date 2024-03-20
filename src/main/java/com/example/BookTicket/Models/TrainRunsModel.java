package com.example.BookTicket.Models;

import com.example.BookTicket.Entity.Train;
import com.example.BookTicket.Entity.TrainRuns;
import com.example.BookTicket.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainRunsModel {
    private Long dayId;
    private String dayname;
    private Train train;
}
