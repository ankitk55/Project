package com.Ankit.Restaurant_Management_Service_API.controller;

import com.Ankit.Restaurant_Management_Service_API.model.*;
import com.Ankit.Restaurant_Management_Service_API.model.dto.SignInInput;
import com.Ankit.Restaurant_Management_Service_API.model.dto.SignUpOutput;
import com.Ankit.Restaurant_Management_Service_API.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;


    @PostMapping("admin/signup")
    public SignUpOutput signUpPatient(@RequestBody Admin admin)
    {
        return adminService.signUpAdmin(admin);
    }


    @PostMapping("admin/signIn")
    public String sigInPatient(@RequestBody @Valid SignInInput signInInput)
    {
        return adminService.signInUser(signInInput);
    }

    @DeleteMapping("admin/signOut")
    public String sigOutAdmin(@RequestParam @Valid String email, String token)
    {
        return adminService.sigOutAdmin(email,token);
        }


    @PostMapping("food")
    public String  addFood(@RequestParam @Valid String email, @RequestParam String token, @RequestBody List<Food> foodList){
        return  adminService.addFood(email, token,foodList);
    }
    @GetMapping("foodList")
    public List<Food> getFoodList(){
       return adminService.getFoodList();
    }
    @GetMapping("user/orders")
    public List<Order>getAllOrder(@RequestParam @Valid String email, @RequestParam String token){
        return adminService.getAllOrders(email,token);
    }

    @GetMapping("users")
        public List<User> getAllUsers(@RequestParam @Valid String email, @RequestParam String token){
        return adminService.getAllUsers(email,token);
    }

    @DeleteMapping("user/order/{orderId}")
    public String deleteOrderById(@RequestParam @Valid String email, @RequestParam String token,@PathVariable Long orderId){
        return adminService.deleteOrderById(email,token,orderId);
    }
    @DeleteMapping("user/account/{userId}")
    public String deleteUserAccount(@RequestParam @Valid String email, @RequestParam String token,@PathVariable Long userId){
        return adminService.deleteUserAccount(email,token,userId);
    }

    @GetMapping("visitors")
    public List<Visitor>getAllVisitors(@RequestParam @Valid String email, @RequestParam String token){
        return adminService.getAllVisitors(email,token);
    }

    @PutMapping("order/status/{orderId}")
    public String updateOrderStatusById(@RequestParam @Valid String email, @RequestParam String token,@PathVariable Long orderId,@RequestParam String orderStatus){
        return adminService.updateOrderStatusById(email,token,orderId,orderStatus);
    }
}
