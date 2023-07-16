package com.Ankit.InstagramBackendBasicDesign.service;

import com.Ankit.InstagramBackendBasicDesign.model.AuthenticationToken;
import com.Ankit.InstagramBackendBasicDesign.model.Post;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import com.Ankit.InstagramBackendBasicDesign.model.dto.SignInInput;
import com.Ankit.InstagramBackendBasicDesign.model.dto.SignUpOutput;
import com.Ankit.InstagramBackendBasicDesign.repository.IUserRpo;
import com.Ankit.InstagramBackendBasicDesign.service.utility.emailUtility.EmailHandler;
import com.Ankit.InstagramBackendBasicDesign.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRpo userRepo;

    @Autowired
    PostService postService;

    @Autowired
    AuthenticationService authenticationService;
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
                authenticationService.createToken(authToken);

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

    public String sigOutUser(String email,String token) {
        if (authenticationService.authenticate(email, token)) {

            User user = userRepo.findFirstByUserEmail(email);
            authenticationService.authTokenRepo.delete(authenticationService.authTokenRepo.findFirstByUser(user));
            return "User Signed out successfully";
        } else {
            return "Sign out not allowed for non authenticated user.";
        }
    }

    public String updateUserEmail(String newEmail, String email, String token) {
        if(authenticationService.authenticate(email,token)){
            User user =userRepo.findFirstByUserEmail(email);
            user.setUserEmail(newEmail);
            userRepo.save(user);
            return "email changed ..";
        }
        return "invalid credentials";
    }

    public String updateUserPhone(String newPhoneNumber, String email, String token) {
        if(authenticationService.authenticate(email,token)){
            User user =userRepo.findFirstByUserEmail(email);
            user.setUserPhoneNumber(newPhoneNumber);
            userRepo.save(user);
            return "phone number changed ..";
        }
        return "invalid credentials";
    }

    public String updatePassword(String newPassword, String email, String token) {
        if(authenticationService.authenticate(email,token)){
            User user =userRepo.findFirstByUserEmail(email);
            try {
                String encryptedPassword = PasswordEncrypter.encryptPassword(newPassword);
                user.setUserPassword(encryptedPassword);
                userRepo.save(user);
                return "password number changed ..";
            }
            catch(Exception e){
                System.out.println("some error occurred during creating a Hash code of Password ");
            }
        }
        return "invalid credentials";
    }

    public String addPost(String email, String token, Post post) {
        if(authenticationService.authenticate(email,token)){
            User user =userRepo.findFirstByUserEmail(email);
          return postService.addPost(user,post);

        }
        return "invalid credentials";

    }

    public String editPost(Long postId, String email, String token, String newPostData) {
        if(authenticationService.authenticate(email,token)){

            User user =userRepo.findFirstByUserEmail(email);
            return postService.editPost(postId,newPostData,user);

        }
        return "invalid credentials";

    }

    public List<Post> getAllPost(String email, String token) {
        if(authenticationService.authenticate(email,token)){
            User user =userRepo.findFirstByUserEmail(email);
            return postService.getAllPost(user);

        }
        return null;

    }

    public String deletePostById(Long postId, String email, String token) {
        if(authenticationService.authenticate(email,token)){
            User user =userRepo.findFirstByUserEmail(email);
            return postService.deletePostById(postId,user);
        }
        return "invalid credentials";

    }

    public String deleteUserAccount(String email, String token) {
        if(authenticationService.authenticate(email,token)){
            User user =userRepo.findFirstByUserEmail(email);
            // signOut the user
            authenticationService.authTokenRepo.delete(authenticationService.authTokenRepo.findFirstByUser(user));
             postService.deleteAllPostByUser(user);
             userRepo.delete(user);
             return "Your Account deleted Successfully ..";
        }
        return "invalid credentials";

    }
}
