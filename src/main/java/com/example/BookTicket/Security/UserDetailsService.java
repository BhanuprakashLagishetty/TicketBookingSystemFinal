package com.example.BookTicket.Security;


import com.example.BookTicket.Entity.Admin;
import com.example.BookTicket.Entity.User;
import com.example.BookTicket.Repository.admin_Repo;
import com.example.BookTicket.Repository.user_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private admin_Repo adminRepo;

    @Autowired
    private user_Repo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (adminRepo.existsByUsername(username)) {
            Admin admin = adminRepo.findByUsername(username);
            if (admin == null) {
                throw new UsernameNotFoundException("Admin username not found");
            }
            return new AdminDetailsImpl(admin);
        }

//
        //if (userRepo.existsByUsername(username)) {
            User user = userRepo.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException(" User username not found");
            }
            return new UserImp(user);
        //}
    }
}
