package com.mikeshaggy.hms.user.service;

import com.mikeshaggy.hms.user.entity.User;
import com.mikeshaggy.hms.user.repository.UserRepository;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validateUser(String username, String password) {
        Optional<User> user = userRepository.findByLogin(username);
        if (user.isEmpty()) {
//            throw new UsernameNotFoundException("Username " + username + " not found");
            throw new RuntimeException();
        }
        if (!user.get().getPassword().equals(password)) {
//            throw new BadCredentialsException("Bad credentials");
            throw new RuntimeException();
        }

        return user.get();
    }
}
