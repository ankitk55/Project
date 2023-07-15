package com.Ankit.Restaurant_Management_Service_API.service;

import com.Ankit.Restaurant_Management_Service_API.model.*;
import com.Ankit.Restaurant_Management_Service_API.model.dto.SignInInput;
import com.Ankit.Restaurant_Management_Service_API.model.dto.SignUpOutput;
import com.Ankit.Restaurant_Management_Service_API.repository.IAdminRepo;
import com.Ankit.Restaurant_Management_Service_API.service.utility.emailUtility.EmailHandler;
import com.Ankit.Restaurant_Management_Service_API.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    FoodService foodService;
    @Autowired
    IAdminRepo adminRepo;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    VisitorService visitorService;
    public String addFood(String email, String token ,List<Food> foodList) {
        if (authenticationService.authenticateAdmin(email, token)) {
            foodService.addFood(foodList);
            return "foods Added..";
        }
        return "Invalid credentials..";
    }

    public List<Food> getFoodList() {
        return foodService.foodRepo.findAll();
    }

    public List<Order> getAllOrders(String email, String token) {
        if (authenticationService.authenticateAdmin(email, token)) {
            return orderService.getAllOrders();
        }
        return null;
    }

    public SignUpOutput signUpAdmin(Admin admin) {
        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = admin.getAdminEmail();

        if (newEmail == null) {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

        //check if this User email already exists ??
        Admin existingAdmin = adminRepo.findFirstByAdminEmail(newEmail);

        if (existingAdmin != null) {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(admin.getAdminPassword());

            //saveAppointment the User with the new encrypted password
            admin.setAdminCreationTimeStamp(LocalDateTime.now());
           admin.setAdminPassword(encryptedPassword);
            adminRepo.save(admin);

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
        Admin existingAdmin = adminRepo.findFirstByAdminEmail(signInEmail);

        if (existingAdmin == null) {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }
        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if (existingAdmin.getAdminPassword().equals(encryptedPassword)) {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken = new AuthenticationToken(existingAdmin);
                authenticationService.addToken(authToken);

               // EmailHandler.sendEmail(signInEmail, "Token for Verify Identity !!!", authToken.getTokenValue());
                return "This is your token : "+authToken.getTokenValue();
            } else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        } catch (Exception e) {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }
    }


    public String sigOutAdmin(String email, String token) {
        if (authenticationService.authenticateAdmin(email, token)) {
            //Admin admin = adminRepo.findFirstByAdminEmail(email);
            authenticationService.deleteToken(token);
            return "Admin Signed out successfully";
        }
        return "Invalid credentials..";
    }

    public List<User> getAllUsers(String email, String token) {
        if (authenticationService.authenticateAdmin(email, token)) {
            return userService.getAllUsers();
        }
        return null;
    }

    public String deleteOrderById(String email, String token, Long orderId) {
        if (authenticationService.authenticateAdmin(email, token)) {
            orderService.deleteById(orderId);
            return "order deleted fot this Id : "+orderId;
        }
        return "invalid Credentials";

    }

    public String deleteUserAccount(String email, String token, Long userId) {
        if (authenticationService.authenticateAdmin(email, token)) {
            User user = userService.userRepo.findById(userId).orElse(null);
            if(user ==null){
                return "Invalid User Id..";
            }
            String userEmail =user.getUserEmail();
            return userService.deleteUserAccount(userEmail);
        }
        return "invalid Credentials";

    }

    public List<Visitor> getAllVisitors(String email, String token) {
        if (authenticationService.authenticateAdmin(email, token)) {
            return visitorService.getAllVisitors();
        }
        return null;

    }

    public String updateOrderStatusById(String email, String token, Long orderId,String orderStatus) {
        if (authenticationService.authenticateAdmin(email, token)) {
            return orderService.updateOrderStatusById(orderId,orderStatus);
        }
        return "invalid credentials";

    }
}
