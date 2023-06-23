package com.Ankit.UserManagementSystem.services;

import com.Ankit.UserManagementSystem.entity.user;
import com.Ankit.UserManagementSystem.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service
public class userService {
    @Autowired
    userRepo userrepo;

    public List<user> getUsers() {
        return userrepo.getUsers();

    }

    public user getUserById(Integer id) {
        for (user User : userrepo.getUsers()) {
            if (id.equals(User.getUserId())) {
                return User;
            }
        }
        return null;
    }

    public String addUser(user User) {
        userrepo.addUser(User);
        return "user Added...";
    }

    public String updateUser(Integer id, String name, String userName, String adress, String phoneNumber) {
        for (user User : userrepo.getUsers()) {
            if (id.equals(User.getUserId())) {
                User.setName(name);
                User.setUserName(userName);
                User.setAdress(adress);
                User.setPhoneNumber(phoneNumber);
                return "User Updated..";
            }
        }
       return "this ID doesnot exist";
    }
    public String deleteUser(Integer id){
        for (user User : userrepo.getUsers()) {
            if (id.equals(User.getUserId())) {
              userrepo.deleteUser(User);
                return "User Delete";
            }
        }
        return "User cant  Delete -This Id Doesnot exist";
    }
}
