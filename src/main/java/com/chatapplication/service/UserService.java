package com.chatapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chatapplication.chat.User;
import com.chatapplication.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public String loginUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.get().getPassword())) {
            return "Welcome>.."+user.get().getUsername();
        }
        return null;
    }
}
