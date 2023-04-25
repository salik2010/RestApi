package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import ru.kata.spring.boot_security.demo.security.SecurityUserDetails;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class MainController {
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }
//    @ResponseBody
//    @GetMapping("/user")
//    public User authenticatedPage( Model model,Principal principal) {
//        User user = userService.selectUser(principal.getName());
//        model.addAttribute("userRole",user);
//
//        return user;
//    }
//    @GetMapping("/userOff")
//    public String authenticatedPageOff( Model model,Principal principal) {
//        User user = userService.selectUser(principal.getName());
//        model.addAttribute("userRole",user);
//
//        return "userOff";
//    }

    @GetMapping("/admin")
    public List<User> adminPage() {
        List<User> allUser=userService.getAll();
        //List<Role> roleall=userService.getRole();
        //User user = userService.selectUser(principal.getName());

       // model.addAttribute("userRole",user);

//        model.addAttribute("users",allUser);
//        model.addAttribute("allroles",roleall);
//        model.addAttribute("name",principal);
//        model.addAttribute("rolles",userService.getRole());
//        model.addAttribute("newuser",new User());
        return allUser;
    }
    @GetMapping("/allrole")
    public List<Role> rolePage() {
        List<Role> roleall=userService.getRole();
        return roleall;
    }

    @PostMapping("/admin")
    public User newUserPost(@RequestBody User user) {

        userService.newUser(user);

        return user;
    }

    @PutMapping("/admin")
    public User editUserPost(@RequestBody User user){
        userService.editUser(user);
        return user;
    }
//    @DeleteMapping("/admin/{id}")
//    public String deleteId(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }
}
