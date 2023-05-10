package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleJpaRepository;
import ru.kata.spring.boot_security.demo.repository.UserJpaRepository;
import ru.kata.spring.boot_security.demo.security.SecurityUserDetails;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    private final UserJpaRepository userJpaRepository;

    private final RoleJpaRepository roleJpaRepository;

    public UserServiceImp(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
    }

    public List<User> getAll(){
        return userJpaRepository.findAll();
    }

    public List<Role> getRole(){
        return roleJpaRepository.findAll();
    }

    public void addRole(Role role){
        roleJpaRepository.save(role);
    }

    @Override
    public void create(User user, Role role) {

    }

    public User selectUser(String name){
        return userJpaRepository.findUserByUsername(name);
    }

    @Transactional
    public boolean create(User user){
        Optional<User> userFromDB = userJpaRepository.findByUsername(user.getUsername());

        if (userFromDB.isPresent()) {
            return false;
        }

        user.setPassword(user.getPassword());
        userJpaRepository.save(user);
        return true;
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
