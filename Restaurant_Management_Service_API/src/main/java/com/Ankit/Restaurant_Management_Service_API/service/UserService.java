package com.Ankit.Restaurant_Management_Service_API.service;

import com.Ankit.Restaurant_Management_Service_API.model.AuthenticationToken;
import com.Ankit.Restaurant_Management_Service_API.model.Food;
import com.Ankit.Restaurant_Management_Service_API.model.Order;
import com.Ankit.Restaurant_Management_Service_API.model.User;
import com.Ankit.Restaurant_Management_Service_API.model.dto.SignInInput;
import com.Ankit.Restaurant_Management_Service_API.model.dto.SignUpOutput;
import com.Ankit.Restaurant_Management_Service_API.repository.IAuthenticationTokenRepo;
import com.Ankit.Restaurant_Management_Service_API.repository.IUserRepo;
import com.Ankit.Restaurant_Management_Service_API.service.utility.emailUtility.EmailHandler;
import com.Ankit.Restaurant_Management_Service_API.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    IAuthenticationTokenRepo authTokenRepo;
    @Autowired
    OrderService orderService;
    @Autowired
    FoodService foodService;


    public String addOrder(Order order, String email, String token) {
        if (authenticationService.authenticate(email, token)) {

            User user = userRepo.findFirstByUserEmail(email);
            order.setUser(user);
            orderService.addOrder(order);
            return "Order created";
        }
        return "Invalid Credientls...";


    }

    public SignUpOutput signUpUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if (newEmail == null) {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

        //check if this User email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if (existingUser != null) {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

            //saveAppointment the User with the new encrypted password
            user.setUserCreationTimeStamp(LocalDateTime.now());
            user.setUserPassword(encryptedPassword);
            userRepo.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        } catch (Exception e) {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

    }

    public String signInUser(SignInInput signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if (signInEmail == null) {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this User email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(signInEmail);

        if (existingUser == null) {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if (existingUser.getUserPassword().equals(encryptedPassword)) {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken = new AuthenticationToken(existingUser);
                authTokenRepo.save(authToken);

                EmailHandler.sendEmail(signInEmail, "Token for Verify Identity !!!", authToken.getTokenValue());
                return "Token sent to your email";
            } else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        } catch (Exception e) {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }

    public String sigOutUser(String email) {

        User user = userRepo.findFirstByUserEmail(email);
        authTokenRepo.delete(authTokenRepo.findFirstByUser(user));
        return "User Signed out successfully";
    }

    public String getStatus(String email, String token, Long orderId) {
        if (authenticationService.authenticate(email, token)) {
            Order orderr = orderService.findById(orderId);
            if (orderr != null) {
                String newEmail = orderr.getUser().getUserEmail();
                if (newEmail.equals(email)) {
                    return "Order status of ID" + orderId + " : " + orderr.getStatus();
                }
            }
            return "Invalid id";
        }
        return "Invalid credentials ...";
    }

    public List<Order> getAllOrders(String email, String token) {
        if (authenticationService.authenticate(email, token)) {
            User user = userRepo.findFirstByUserEmail(email);

            return orderService.getAllOrder(user.getUserId());
        }
        return null;
    }

    public String deleteOrderById(String email, String token, Long id) {
        if (authenticationService.authenticate(email, token)) {
            User user = userRepo.findFirstByUserEmail(email);
            Order order = orderService.findById(id);
            if (order != null && order.getUser().getUserEmail().equals(email)) {
                orderService.deleteById(id);
                return "Order deleted.";
            }
            return "Invalid Order id...";
        }
        return "Invalid Credentials ..";
    }

    public String deleteUserAccount(String email) {

            sigOutUser(email);
            User user = userRepo.findFirstByUserEmail(email);
            List<Order> order = orderService.getAllOrder(user.getUserId());
            List<Long> ordersIds = new ArrayList<>();
            for (Order ordeer : order) {
                ordersIds.add(ordeer.getOrderId());
            }
            orderService.deleteAllById(ordersIds);

            userRepo.delete(user);
            return "user Account deleted Successfully !!!";
        }


    public List<Food> getFoodlist() {
        return foodService.getFoodlist();
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}





