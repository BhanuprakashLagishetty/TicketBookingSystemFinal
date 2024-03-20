package com.example.BookTicket.Repository;

import com.example.BookTicket.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface seat_Repo  extends JpaRepository<Seat,Long> {
}
