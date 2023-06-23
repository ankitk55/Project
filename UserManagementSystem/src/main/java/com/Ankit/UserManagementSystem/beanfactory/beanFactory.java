package com.Ankit.UserManagementSystem.beanfactory;

import com.Ankit.UserManagementSystem.entity.user;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class beanFactory {
    @Bean
    public List<user> getUserObject(){
        return new ArrayList<>();
    }
}
