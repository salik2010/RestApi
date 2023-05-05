package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final UserService userService;

    public RestController(UserService userService) {
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

        //List<Role> roleall=userService.getRole();
        //User user = userService.selectUser(principal.getName());

       // model.addAttribute("userRole",user);

//        model.addAttribute("users",allUser);
//        model.addAttribute("allroles",roleall);
//        model.addAttribute("name",principal);
//        model.addAttribute("rolles",userService.getRole());
//        model.addAttribute("newuser",new User());
        return userService.getAll();
    }



    @GetMapping("/roles")
    public List<Role> allRoles() {
        List<Role> roleList = userService.getRole();
        return roleList;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.newUser(user);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {

        return userService.getById(id);
    }

    @PatchMapping(value = "/users/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody User user, @PathVariable("id") Long id, Model model) {
        userService.editUser(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }


}
