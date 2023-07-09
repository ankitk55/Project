package com.Ankit.ECommerceAPI.service;

import com.Ankit.ECommerceAPI.model.OrderEntity;
import com.Ankit.ECommerceAPI.model.Product;
import com.Ankit.ECommerceAPI.repository.IOrderEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderEntityService {
    @Autowired
    IOrderEntityRepo orderEntityRepo;

    public void addOrder(OrderEntity orderEntity) {
        orderEntityRepo.save(orderEntity);
    }

    public Optional<OrderEntity> getOrderById(Integer id) {
        return orderEntityRepo.findById(id);
    }


    public void deleteOrderById(Integer id) {
        orderEntityRepo.deleteById(id);
    }
}

