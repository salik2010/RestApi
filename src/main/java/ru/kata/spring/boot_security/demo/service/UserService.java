package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;


import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAll();

    public boolean create(User user);

    public void deleteUser(Long id);

    public User editUser(User user);

    public User getById(Long id);

    public List<Role> getRole();

    public void create(User user,Role role);

    public void addRole(Role role);

    public User selectUser(String name);



}
