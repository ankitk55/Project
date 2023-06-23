package com.Ankit.UserManagementSystem.controller;

import com.Ankit.UserManagementSystem.entity.user;
import com.Ankit.UserManagementSystem.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {
    @Autowired
    userService userservice;
    @PostMapping("addUser")
    public String addUser(@RequestBody user User){
        return userservice.addUser(User);
    }
@GetMapping("getAllUser")
    public List<user> getUsers(){
        return userservice.getUsers();
    }
    @GetMapping("getUser/{id}")
    public user getUserById(@PathVariable Integer id){
    return userservice.getUserById(id);
    }
    @PutMapping("updateUserInfo/Id/{id}")
    public String updateUser(@PathVariable Integer id,@RequestParam String name,@RequestParam String userName,@RequestParam String adress,@RequestParam String phoneNumber){
        return userservice.updateUser(id,name,userName,adress,phoneNumber);
    }
    @DeleteMapping("deleteUser/Id/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userservice.deleteUser(id);
    }
}
