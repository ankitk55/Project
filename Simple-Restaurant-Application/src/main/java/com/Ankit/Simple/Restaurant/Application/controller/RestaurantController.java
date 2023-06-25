package com.Ankit.Simple.Restaurant.Application.controller;

import com.Ankit.Simple.Restaurant.Application.model.Menu;
import com.Ankit.Simple.Restaurant.Application.model.Restaurant;
import com.Ankit.Simple.Restaurant.Application.model.categeory.Categeory;
import com.Ankit.Simple.Restaurant.Application.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("Restaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("Restaurant/id/{id}")
    public Restaurant getRestaurantById(@PathVariable Integer id){
        return restaurantService.getRestaurantById(id);
    }
    @PostMapping("Restaurant")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurent(restaurant);
    }
    @PutMapping("Restaurant/menu/id/{id}")
    public String updateMenu(@PathVariable Integer id, @RequestBody List<Menu> menuList){
        return restaurantService.updateMenu(id,menuList);
    }
    @PutMapping("Restaurant/OpeningHour/id/{id}/newTime/{newTime}")
    public String updateOpeningHours(@PathVariable Integer id,@PathVariable String newTime){
        return restaurantService.updateopeningHours(id,newTime);
    }
    @PutMapping("Restaurant/name/id/{id}/newName/{newName}")
    public String updateRestaurantName(@PathVariable Integer id, @PathVariable String newName){
        return restaurantService.updateRestaraurantName(id,newName);
    }
    @PutMapping("Restaurant/Address/id/{id}/newAddress/{newAddress}")
    public String updateRestaurantAddress(@PathVariable Integer id, @PathVariable String newAddress){
        return restaurantService.updateRestaurantAddress(id,newAddress);
    }
    @PutMapping("Restaurant/Phone/id/{id}/newPhone/{newPhone}")
    public String updateRestaurantPhone(@PathVariable Integer id, @PathVariable String newPhone){
        return restaurantService.updateRestaurantPhone(id,newPhone);
    }
    @PutMapping("Restaurant/Categeory/id/{id}/newcategeory/{newcategeory}")
    public String updateRestaurantCategeory(@PathVariable Integer id, @PathVariable Categeory newcategeory){
        return restaurantService.updateCategeory(id,newcategeory);
    }

    @PutMapping("Restaurant/StaffCount/id/{id}/newCount/{newCount}")
    public String updateStaffCount(@PathVariable Integer id, @PathVariable Integer newCount){
        return restaurantService.updateStaffCount(id,newCount);
    }

    @PutMapping("Restaurant/tableCount/id/{id}/newCount/{newCount}")
    public String updateTableCount(@PathVariable Integer id, @PathVariable Integer newCount){
        return restaurantService.updatetableCount(id,newCount);
    }
    @DeleteMapping("Restaurant/id/{id}")
    public  String deleteRestaurant( @PathVariable Integer id){
        return restaurantService.deleteRestaurent(id);
    }
}
