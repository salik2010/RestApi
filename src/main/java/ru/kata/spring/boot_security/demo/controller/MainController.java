package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.kata.spring.boot_security.demo.entity.Role;
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

    @GetMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        List<User> allUser=userService.getAll();

        model.addAttribute("users",allUser);

        model.addAttribute("name",principal);
        return "admin";
    }
    @GetMapping("/admin/new")
    public String newUser(Model model) {
        User user = new User();
        Role role =new Role();
        model.addAttribute("role",role);
        model.addAttribute("newuser",user);
        return "new";
    }
    @PostMapping("/admin/new")
    public String newUserPost(@ModelAttribute("newuser") User user,Role role){
        userService.newUser(user,role);

        return "redirect:/admin";
    }
    @PatchMapping("/admin/edit/{id}")
    public String editUser(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("edituser",user);
        return "edit";
    }
    @PostMapping("/admin/edit")
    public String editUserPost(User user){
        userService.editUser(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/admin/delete/{id}")
    public String deleteId(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
