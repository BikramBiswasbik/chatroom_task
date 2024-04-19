package com.chatapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapplication.chat.User;
import com.chatapplication.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/message")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getMessage() {
        return "welcome";
    }
    
    
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/page")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String loginUser(@RequestBody User user) {
        return userService.loginUser(user.getUsername(), user.getPassword());
//        return "welcome"+user.getUsername();
    }
}
