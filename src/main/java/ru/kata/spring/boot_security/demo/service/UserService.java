package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;


import java.util.List;

public interface UserService {
    public List<User> getAll();
    public void newUser(User user);
    public void deleteUser(Long id);
    public User editUser(User user);
    public User getById(Long id);
    public List<Role> getRole();
    public void newUser(Role role);
}
