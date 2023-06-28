package com.Ankit.User.Management.System.with.Validations.service;

import com.Ankit.User.Management.System.with.Validations.model.User;
import com.Ankit.User.Management.System.with.Validations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class UserService {
   @Autowired
    UserRepository userRepository;
public List<User> getAllUers(){
    return userRepository.getUsers();
}

public User getUserById(Integer id){
    List<User>originalList = userRepository.getUsers();
    for(User user:originalList){
        if(user.getUserId().equals(id)){
            return user;
        }
    }
    return null;
}

public String addUser(User user){
    List<User>originalList = userRepository.getUsers();
    originalList.add(user);
    return "User added..";
}
public String updateUserName(Integer id,String userName){
    List<User>originalList = userRepository.getUsers();
    for(User user:originalList){
        if(user.getUserId().equals(id)){
           user.setUserName(userName);
           return "Username Changed";
        }
    }
    return "invalid Id..";

}
    public String updateEmail(Integer id,String email){
        List<User>originalList = userRepository.getUsers();
        for(User user:originalList){
            if(user.getUserId().equals(id)){
                user.setUserEmail(email);
                return "UserEmail Changed";
            }
        }
        return "invalid Id..";
    }
    public String updatePhone(Integer id,String phone){
        List<User>originalList = userRepository.getUsers();
        for(User user:originalList){
            if(user.getUserId().equals(id)){
                user.setUserPhone(phone);
                return "UserPhone Changed";
            }
        }
        return "invalid Id..";
    }
    public String updateUserDOB(Integer id, LocalDate DOB){
        List<User>originalList = userRepository.getUsers();
        for(User user:originalList){
            if(user.getUserId().equals(id)){
                user.setUserDOB(DOB);
                return "UserDOB Changed";
            }
        }
        return "invalid Id..";
    }
    public String updateDate(Integer id,LocalDate date){
        List<User>originalList = userRepository.getUsers();
        for(User user:originalList){
            if(user.getUserId().equals(id)){
                user.setDate(date);
                return "date Changed";
            }
        }
        return "invalid Id..";
    }
    public String updateTime(Integer id, LocalTime time){
        List<User>originalList = userRepository.getUsers();
        for(User user:originalList){
            if(user.getUserId().equals(id)){
                user.setTime(time);
                return "time Changed";
            }
        }
        return "invalid Id..";
    }
    public String deleteUser(Integer id){
        List<User>originalList = userRepository.getUsers();
        for(User user:originalList){
            if(user.getUserId().equals(id)){
              userRepository.deleteUser(user);
                return "User Deleted";
            }
        }
        return "invalid Id..";
    }

    public String updateUserInfo(Integer id, String userName, String email, String phone, LocalDate dob, LocalDate date, LocalTime time) {
        List<User>originalList = userRepository.getUsers();
        for(User user:originalList){
            if(user.getUserId().equals(id)){
              user.setUserName(userName);
              user.setUserEmail(email);
              user.setUserPhone(phone);
              user.setUserDOB(dob);
              user.setDate(date);
              user.setTime(time);
                return "Userinfo changed..";
            }
        }
        return "Invalid Id";
    }
}
