package com.Ankit.Restaurant_Management_Service_API.service;

import com.Ankit.Restaurant_Management_Service_API.model.Food;
import com.Ankit.Restaurant_Management_Service_API.repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo foodRepo;
    public void addFood(List<Food> foodList){
        foodRepo.saveAll(foodList);
    }

    public List<Food> getFoodlist() {
        return foodRepo.findAll();
    }
}
