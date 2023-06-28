package com.Ankit.User.Management.System.with.Validations.beanManager;

import com.Ankit.User.Management.System.with.Validations.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanManager {
    @Bean
    public List<User> getObject(){
        return new ArrayList<>();
    }
}
