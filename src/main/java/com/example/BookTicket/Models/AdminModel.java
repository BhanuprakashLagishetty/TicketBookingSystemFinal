package com.example.BookTicket.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel {
    private Long adminId;
    private String username;
    private String password;
    private String role="ROLE_ADMIN";
}
