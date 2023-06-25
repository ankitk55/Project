package com.Ankit.Simple.Restaurant.Application.beanFactory;

import com.Ankit.Simple.Restaurant.Application.model.Menu;
import com.Ankit.Simple.Restaurant.Application.model.Restaurant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanManager {
    @Bean
    public List<Restaurant> getObject(){
        return new ArrayList<>();
    }
    @Bean
    public List<Menu> getObjectOfMenu(){
        return new ArrayList<>();
    }

}
