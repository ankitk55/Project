package com.Ankit.Restaurant_Management_Service_API.controller;

import com.Ankit.Restaurant_Management_Service_API.model.Food;
import com.Ankit.Restaurant_Management_Service_API.model.Order;
import com.Ankit.Restaurant_Management_Service_API.model.User;
import com.Ankit.Restaurant_Management_Service_API.model.dto.SignInInput;
import com.Ankit.Restaurant_Management_Service_API.model.dto.SignUpOutput;
import com.Ankit.Restaurant_Management_Service_API.service.AuthenticationService;
import com.Ankit.Restaurant_Management_Service_API.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("user/signup")
    public SignUpOutput signUpPatient(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInPatient(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutPatient(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    @PostMapping("Order")
    public String addOrder( @RequestBody Order order, @RequestParam @Valid String email, String token){
        return userService.addOrder(order, email,token);
    }
    @GetMapping("orders")
        public List<Order> getAllOrders(@RequestParam @Valid String email,@RequestParam String token ){
        return userService.getAllOrders(email,token);

    }

    @GetMapping("order/status/{orderId}")
    public String getStatus(@RequestParam @Valid String email, @RequestParam String token,@PathVariable Long orderId){
        return userService.getStatus(email,token,orderId);
    }

    @GetMapping("foods")
    public List<Food> getFoodlist(){
        return userService.getFoodlist();
    }

    @DeleteMapping("order/{id}")
    public String deleteOrderById(@RequestParam @Valid String email,@RequestParam String token ,@PathVariable Long id){
        return userService.deleteOrderById(email,token,id);
    }

    @DeleteMapping("user/account")
    public String deleteUserAccount(@RequestParam @Valid String email,@RequestParam String token){
        if (authenticationService.authenticate(email, token)) {
            return userService.deleteUserAccount(email);
        }
        return "Invalid Credentials";
    }
}
