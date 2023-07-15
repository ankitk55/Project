package com.Ankit.Restaurant_Management_Service_API.controller;

import com.Ankit.Restaurant_Management_Service_API.model.Food;
import com.Ankit.Restaurant_Management_Service_API.model.Visitor;
import com.Ankit.Restaurant_Management_Service_API.service.FoodService;
import com.Ankit.Restaurant_Management_Service_API.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitorController {
    @Autowired
    FoodService foodService;
    @Autowired
    VisitorService visitorService;
    @PostMapping("visitor")
    public void addVisitor(@RequestBody Visitor visitor){
        visitorService.addVisitor(visitor);
    }
    @GetMapping("foodsList")
    public List<Food> getAllFoodItem(){
       return  foodService.getFoodlist();
    }
}
