package com.example.BookTicket.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
public class SearchTrainModel {
    private String arrivalStation;
    private String departureStation;
    private LocalDate bookingDate;

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "SearchTrainModel{" +
                "arrivalStation='" + arrivalStation + '\'' +
                ", departureStation='" + departureStation + '\'' +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
