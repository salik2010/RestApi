package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.UserJpaRepository;

import java.util.List;
@Service
public class UserServiceImp implements UserService{
    private final UserJpaRepository userJpaRepository;

    public UserServiceImp(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public List<User> getAll(){
        return userJpaRepository.findAll();
    }
    @Transactional
    public void newUser(User user){
        userJpaRepository.save(user);
    }
}
