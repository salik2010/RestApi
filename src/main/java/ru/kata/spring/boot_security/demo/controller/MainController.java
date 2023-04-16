package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String authenticatedPage(Principal principal) {
        return "user";
    }
//    @GetMapping("/user")
//    public String authenticatedPage1(Principal principal) {
//        return "index";
//    }
    @GetMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        List<User> allUser=userService.getAll();
        model.addAttribute("users",allUser);

        return "admin";
    }
    @PutMapping("/admin/new")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("newuser",user);
        return "new";
    }
    @PostMapping("/admin/new")
    public String newUserPost(@ModelAttribute("newuser") User user){
        userService.newUser(user);
        return "redirect:/";
    }
}
