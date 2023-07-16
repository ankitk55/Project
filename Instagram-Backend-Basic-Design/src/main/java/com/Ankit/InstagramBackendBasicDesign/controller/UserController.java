package com.Ankit.InstagramBackendBasicDesign.controller;

import com.Ankit.InstagramBackendBasicDesign.model.Post;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import com.Ankit.InstagramBackendBasicDesign.model.dto.SignInInput;
import com.Ankit.InstagramBackendBasicDesign.model.dto.SignUpOutput;
import com.Ankit.InstagramBackendBasicDesign.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {
        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutUser(String email, String token) {
        return userService.sigOutUser(email, token);
    }

    @PutMapping("user/email/{newEmail}")
    public String updateUserEmail(@PathVariable String newEmail,@RequestParam @Valid String email, @RequestParam String token){
        return userService.updateUserEmail(newEmail,email,token);
    }
    @PutMapping("user/phone/{newPhoneNumber}")
    public String updateUserPhone(@PathVariable String newPhoneNumber,@RequestParam @Valid String email, @RequestParam String token){
        return userService.updateUserPhone(newPhoneNumber,email,token);
    }
    @PutMapping("user/password/{newPassword}")
    public String updatePassword(@PathVariable @Valid String newPassword,@RequestParam @Valid String email, @RequestParam String token){
        return userService.updatePassword(newPassword,email,token);
    }

    @PostMapping("createPost")
    public String addPost(@RequestParam @Valid String email, @RequestParam String token,@RequestBody Post post){
        return userService.addPost(email,token,post);
    }

    @PutMapping("edit/post/{postId}")
    public String editPost(@PathVariable Long postId,@RequestParam @Valid String email, @RequestParam String token,@RequestParam String newPostData){
        return userService.editPost(postId,email,token,newPostData);
    }

    @GetMapping("posts")
    public List<Post> getAllPost(@RequestParam @Valid String email, @RequestParam String token){
        return userService.getAllPost(email,token);
    }

    @DeleteMapping("post/{postId}")
    public String deletePostById(@PathVariable Long postId,@RequestParam @Valid String email, @RequestParam String token){
        return userService.deletePostById(postId,email,token);
    }

    @DeleteMapping("user/account")
    public String deleteUserAccount(@RequestParam @Valid String email,@RequestParam String token){

            return userService.deleteUserAccount(email,token);
    }



}
