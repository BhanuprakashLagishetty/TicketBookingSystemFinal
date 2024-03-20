package com.example.BookTicket.Repository;

import com.example.BookTicket.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticket_Repo extends JpaRepository<Ticket,Long> {
}
