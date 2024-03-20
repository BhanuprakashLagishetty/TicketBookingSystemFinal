package com.example.BookTicket.Repository;

import com.example.BookTicket.Entity.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface waitingList_Repo extends JpaRepository<WaitingList,Long> {

}
