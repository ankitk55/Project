package com.Ankit.Restaurant_Management_Service_API.repository;

import com.Ankit.Restaurant_Management_Service_API.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderRepo extends JpaRepository<Order,Long> {

   @Query(value = "SELECT * FROM FOOD_ORDER WHERE FK_USER_ID = :id",nativeQuery = true)
   public List<Order> getAllOrder(Long id);


}
