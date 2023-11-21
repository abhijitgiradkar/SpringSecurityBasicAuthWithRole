package com.learn.springbootsecuritylearn.services;

import com.learn.springbootsecuritylearn.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    List<User> users = new ArrayList<>();

    public UserServices() {
        users.add(new User("Abhijit","12345","abhi@gmail.com"));
        users.add(new User("xyz","12345","abhi@gmail.com"));
        users.add(new User("abc","12345","abhi@gmail.com"));
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    public User getUser(String username) {
        return this.users.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user) {
        this.users.add(user);
        return user;
    }
}
