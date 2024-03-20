package com.example.BookTicket.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceGenerationModel {
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public int getStartKm() {
        return StartKm;
    }

    public void setStartKm(int startKm) {
        StartKm = startKm;
    }

    public int getDepartureKm() {
        return departureKm;
    }

    public void setDepartureKm(int departureKm) {
        this.departureKm = departureKm;
    }

    private String To;
    private int StartKm;
    private int departureKm;
}
