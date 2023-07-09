package com.Ankit.ECommerceAPI.service;

import com.Ankit.ECommerceAPI.model.User;
import com.Ankit.ECommerceAPI.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public Optional<User> getUserById(Integer id) {
        return userRepo.findById(id);
    }
}
