package com.Ankit.Restaurant_Management_Service_API.service;

import com.Ankit.Restaurant_Management_Service_API.model.Admin;
import com.Ankit.Restaurant_Management_Service_API.model.AuthenticationToken;
import com.Ankit.Restaurant_Management_Service_API.repository.IAuthenticationTokenRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationTokenRepo authTokenRepo;

    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authTokenRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);
    }
    public boolean authenticateAdmin(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authTokenRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getAdmin().getAdminEmail();

        return tokenConnectedEmail.equals(email);
    }

    public void addToken(AuthenticationToken authToken) {
        authTokenRepo.save(authToken);
    }

    public void deleteToken(String token) {
       AuthenticationToken authToken = authTokenRepo.findFirstByTokenValue(token);
       authTokenRepo.delete(authToken);
    }
}
