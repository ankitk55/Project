package com.Ankit.Restaurant_Management_Service_API.service;

import com.Ankit.Restaurant_Management_Service_API.model.Order;
import com.Ankit.Restaurant_Management_Service_API.repository.IOrderRepo;
import com.Ankit.Restaurant_Management_Service_API.service.utility.emailUtility.EmailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;

    public void addOrder(Order order) {
        order.setFoodQuantity(order.getFood().size());
        order.setOrderCreationTimeStamp(LocalDateTime.now());
        orderRepo.save(order);


    }

    public List<Order> getAllOrder(Long userId) {
       return orderRepo.getAllOrder(userId);
    }

    public Order findById(Long orderId) {
         return orderRepo.findById(orderId).orElse(null);
    }

    public void deleteById(Long id) {
        orderRepo.deleteById(id);
    }

    public void deleteAllById(List<Long> ordersIds) {
        orderRepo.deleteAllById(ordersIds);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public String updateOrderStatusById(Long orderId, String orderStatus) {
        Order orderr =orderRepo.findById(orderId).orElse(null);
        if(orderr==null){
            return "invalid Order Id ..";
        }
        orderr.setStatus(orderStatus);
        orderRepo.save(orderr);
        return "order status updated for this Order Id : "+orderId;
    }
}
