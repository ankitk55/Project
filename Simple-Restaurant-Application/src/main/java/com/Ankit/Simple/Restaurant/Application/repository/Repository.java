package com.Ankit.Simple.Restaurant.Application.repository;

import com.Ankit.Simple.Restaurant.Application.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Repository
public class Repository {
    @Autowired
   private List<Restaurant> restaurants;

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurent(Restaurant restaurant){
        restaurants.add(restaurant);
    }
    public void deleteReataurant(Restaurant restaurant){
        restaurants.remove(restaurant);
    }
}
