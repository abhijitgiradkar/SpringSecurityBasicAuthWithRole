package com.learn.springbootsecuritylearn.controller;

import com.learn.springbootsecuritylearn.models.User;
import com.learn.springbootsecuritylearn.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return this.userServices.addUser(user);
    }

    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userServices.getUser(username);
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return this.userServices.getAllUsers();
    }
}
