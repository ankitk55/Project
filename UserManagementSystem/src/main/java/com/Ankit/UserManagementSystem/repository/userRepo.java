package com.Ankit.UserManagementSystem.repository;

import com.Ankit.UserManagementSystem.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class userRepo {
@Autowired
    private List<user> users;

    public List<user> getUsers(){
        return users;
    }
    public void addUser(user User){
        users.add(User);
    }
    public void deleteUser(user User){
        users.remove(User);
    }

}
