package com.example.BookTicket.Repository;

import com.example.BookTicket.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface train_Repo extends JpaRepository<Train,Long> {
}
