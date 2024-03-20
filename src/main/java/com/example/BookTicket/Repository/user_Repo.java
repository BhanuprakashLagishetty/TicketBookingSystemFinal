package com.example.BookTicket.Repository;

import com.example.BookTicket.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_Repo extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);

    User findByUsername(String username);
}
