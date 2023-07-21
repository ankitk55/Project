package com.Ankit.User.Management.System.with.Validations.controller;

import com.Ankit.User.Management.System.with.Validations.model.User;
import com.Ankit.User.Management.System.with.Validations.service.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Validated

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("getAllUser")
    public List<User> getAllUsers(){
        return userService.getAllUers();
    }

    @GetMapping("getUser/id/{id}")
    public User getUserById(@PathVariable  Integer id){
        return userService.getUserById(id);
    }
    @PostMapping("addUser")
    public String addUser( @RequestBody @Valid User user){
        return userService.addUser(user);
    }
    @PutMapping("user/userName/id/{id}/userName/{userName}")
    public String updateUserName(@PathVariable Integer id,@PathVariable @NotBlank String userName){
        return userService.updateUserName(id,userName);
    }
    @PutMapping("user/email/id/{id}/email/{email}")
    public String updateEmail(@PathVariable  Integer id,@PathVariable @Email String email){
        return userService.updateEmail(id,email);
    }
    @PutMapping("user/phone/id/{id}/phone/{phone}")
    public String updatePhone(@PathVariable Integer id,@PathVariable @Pattern(regexp = "^91\\d{10}$") String phone){
        return userService.updatePhone(id,phone);
    }
    @PutMapping("user/DOB/id/{id}/DOB/{DOB}")
    public String updateUserDOB(@PathVariable  Integer id,@PathVariable  LocalDate DOB){
        return userService.updateUserDOB(id,DOB);
    }
    @PutMapping("user/date/id/{id}/date/{date}")
    public String updateDate(@PathVariable Integer id,@PathVariable  LocalDate date){
       return userService.updateDate(id,date);
    }
    @PutMapping("user/time/id/{id}/time/{time}")
    public String updateTime(@PathVariable  Integer id,@PathVariable  LocalTime time){
        return userService.updateTime(id,time);
    }
    @PutMapping("updateUserInfo/id/{id}")
    public String updateUserInfo(@PathVariable Integer id,@RequestParam @NotBlank String userName,@RequestParam @Email String email,@RequestParam @Pattern(regexp = "^91\\d{10}$") String phone,@RequestParam LocalDate dob,@RequestParam LocalDate date,@RequestParam LocalTime time){
        return userService.updateUserInfo(id,userName,email,phone,dob,date,time);
    }
    @DeleteMapping("deleteUser/id/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
