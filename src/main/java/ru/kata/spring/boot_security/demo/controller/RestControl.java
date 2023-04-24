package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestControl {
    public final UserService userService;

    public RestControl(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/all")
    public List<User> adminPageRest() {
        List<User> allUser=userService.getAll();

        return allUser;
    }
    @GetMapping("/all/{id}")
    public User PageRestId(@PathVariable Long id) {
        return userService.getById(id);
    }

}
