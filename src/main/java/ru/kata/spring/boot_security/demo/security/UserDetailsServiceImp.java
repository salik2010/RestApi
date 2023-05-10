package ru.kata.spring.boot_security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.UserJpaRepository;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserServiceImp userServiceImp;

    private final UserJpaRepository userJpaRepository;

    public UserDetailsServiceImp(UserServiceImp userServiceImp, UserJpaRepository userJpaRepository) {
        this.userServiceImp = userServiceImp;
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userJpaRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new SecurityUserDetails(user.get());
    }
}
