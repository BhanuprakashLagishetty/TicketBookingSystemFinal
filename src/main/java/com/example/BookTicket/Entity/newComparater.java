package com.example.BookTicket.Entity;

import java.util.Comparator;

public class newComparater implements Comparator<Stations> {
    @Override
    public int compare(Stations o1, Stations o2) {
        return o1.getKm()-o2.getKm();
    }
}
