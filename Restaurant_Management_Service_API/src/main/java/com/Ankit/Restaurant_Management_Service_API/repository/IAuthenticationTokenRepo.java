package com.Ankit.Restaurant_Management_Service_API.repository;

import com.Ankit.Restaurant_Management_Service_API.model.Admin;
import com.Ankit.Restaurant_Management_Service_API.model.AuthenticationToken;
import com.Ankit.Restaurant_Management_Service_API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationTokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByUser(User user);

    AuthenticationToken findFirstByTokenValue(String authTokenValue);



}
