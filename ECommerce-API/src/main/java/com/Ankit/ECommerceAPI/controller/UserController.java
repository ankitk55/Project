package com.Ankit.ECommerceAPI.controller;

import com.Ankit.ECommerceAPI.model.User;
import com.Ankit.ECommerceAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    @GetMapping("user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
}
