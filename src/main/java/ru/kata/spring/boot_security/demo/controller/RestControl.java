package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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


//    @GetMapping("/user")
//    public String authenticatedPage( Model model,Principal principal) {
//        User user = userService.selectUser(principal.getName());
//        model.addAttribute("userRole",user);
//
//        return "user";
//    }
//    @GetMapping("/userOff")
//    public String authenticatedPageOff( Model model,Principal principal) {
//        User user = userService.selectUser(principal.getName());
//        model.addAttribute("userRole",user);
//
//        return "userOff";
//    }
//    @GetMapping("/admin")
//    public String adminPage(Principal principal, Model model) {
//        List<User> allUser=userService.getAll();
//        List<Role> roleall=userService.getRole();
//        User user = userService.selectUser(principal.getName());
//
//        model.addAttribute("userRole",user);
//
//        model.addAttribute("users",allUser);
//        model.addAttribute("allroles",roleall);
//        model.addAttribute("name",principal);
//        model.addAttribute("rolles",userService.getRole());
//        model.addAttribute("newuser",new User());
//        return "admin";
//    }
//
//    @PostMapping("/admin")
//    public String newUserPost(@ModelAttribute("newuser") User user) {
//
//        userService.newUser(user);
//
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/admin/{id}")
//    public String editUserPost(@ModelAttribute("user") User user){
//
//        userService.editUser(user);
//
//        return "redirect:/admin";
//    }
//    @DeleteMapping("/admin/{id}")
//    public String deleteId(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }

}
