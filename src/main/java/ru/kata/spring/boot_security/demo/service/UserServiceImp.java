package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleJpaRepository;
import ru.kata.spring.boot_security.demo.repository.UserJpaRepository;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserJpaRepository userJpaRepository;
    private final RoleJpaRepository roleJpaRepository;
    public UserServiceImp(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
    }

    public List<User> getAll(){
        return userJpaRepository.findAll();
    }

    @Override
    public void newUser(User user) {

    }

    public List<Role> getRole(){
        return roleJpaRepository.findAll();
    }
    @Transactional
    public void newUser(User user,Role role){
        userJpaRepository.save(user);
        roleJpaRepository.save(role);
    }

    @Transactional
    public void deleteUser(Long id){
        userJpaRepository.deleteById(id);
    }
    @Transactional
    public User editUser(User user){
        return userJpaRepository.save(user);
    }
    public User getById(Long id){
        return userJpaRepository.getById(id);
    }

}
