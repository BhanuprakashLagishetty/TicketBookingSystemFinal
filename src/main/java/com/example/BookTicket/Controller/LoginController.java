package com.example.BookTicket.Controller;

import com.example.BookTicket.Models.AdminModel;
import com.example.BookTicket.Service.AdminService;
import com.example.BookTicket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
        @Autowired
        private AdminService adminService;

        @Autowired
        private UserService userService;
        @RequestMapping("/")
        public String home()
        {
            return "home";
        }
        @RequestMapping("/UserLogin")
        public String userLogin()
        {
                return "userLogin";
        }
        @RequestMapping("/adminLogin")
        public String adminLogin()
        {
                return "adminLogin";
        }

        @RequestMapping("/loginAdmin")
        public String loginUser(AdminModel adminModel)
        {
                return adminService.checkAdminLogin(adminModel) ? "index" : "adminLogin";
        }
}


