package com.example.BookTicket.Repository;

import com.example.BookTicket.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface booking_Repo extends JpaRepository<Booking,Long> {
}
