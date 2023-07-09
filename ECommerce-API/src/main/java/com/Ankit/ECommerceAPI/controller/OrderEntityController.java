package com.Ankit.ECommerceAPI.controller;

import com.Ankit.ECommerceAPI.model.OrderEntity;
import com.Ankit.ECommerceAPI.service.OrderEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderEntityController {
    @Autowired
    OrderEntityService orderEntityService;
    @PostMapping("order")
    public void addOrder(@RequestBody  OrderEntity orderEntity){
        orderEntityService.addOrder(orderEntity);
    }
    @GetMapping("order/{id}")
    public Optional<OrderEntity> getOrderById(@PathVariable Integer id){
        return orderEntityService.getOrderById(id);
    }
    @DeleteMapping("order/{id}")
    public void deleteOrderById(@PathVariable Integer id){
        orderEntityService.deleteOrderById(id);
    }
}
