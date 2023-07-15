package com.Ankit.Restaurant_Management_Service_API.repository;

import com.Ankit.Restaurant_Management_Service_API.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<Food,Long> {
}
