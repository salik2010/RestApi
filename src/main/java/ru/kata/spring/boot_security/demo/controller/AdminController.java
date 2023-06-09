package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
        private UserService userService;

        @Autowired
        public AdminController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping()
        public String allUsers(Model model, Principal principal) {

            User user = userService.selectUser(principal.getName());
            model.addAttribute("users1",userService.getAll());
            model.addAttribute("userRole",user);

            return "admin";
        }

}
