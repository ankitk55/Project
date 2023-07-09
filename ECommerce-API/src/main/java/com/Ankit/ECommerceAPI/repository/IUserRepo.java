package com.Ankit.ECommerceAPI.repository;

import com.Ankit.ECommerceAPI.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepo extends CrudRepository<User,Integer> {
}
