package com.example.BookTicket.Repository;

import com.example.BookTicket.Entity.BookingDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookingDate_Repo extends JpaRepository<BookingDate,Long> {
}
