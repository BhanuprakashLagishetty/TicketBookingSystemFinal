package com.example.BookTicket.Repository;

import com.example.BookTicket.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface payment_Repo extends JpaRepository<Payment,Long> {
}
