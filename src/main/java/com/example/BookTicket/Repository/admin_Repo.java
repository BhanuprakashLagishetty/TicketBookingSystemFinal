package com.example.BookTicket.Repository;

import com.example.BookTicket.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface admin_Repo extends JpaRepository<Admin,Integer> {
    boolean existsByUsername(String username);

    Admin findByUsername(String username);
}
