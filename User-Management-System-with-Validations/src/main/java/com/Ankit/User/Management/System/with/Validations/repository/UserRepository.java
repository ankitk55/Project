package com.Ankit.User.Management.System.with.Validations.repository;

import com.Ankit.User.Management.System.with.Validations.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepository {
    @Autowired
   private List<User> users;

    public List<User> getUsers() {
        return users;
    }
    public void deleteUser(User user){
        users.remove(user);
    }
}
