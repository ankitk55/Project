package com.Ankit.ECommerceAPI.repository;

import com.Ankit.ECommerceAPI.model.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface IOrderEntityRepo extends CrudRepository<OrderEntity,Integer> {
}
