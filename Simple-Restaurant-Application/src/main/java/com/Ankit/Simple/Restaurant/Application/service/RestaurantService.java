package com.Ankit.Simple.Restaurant.Application.service;

import com.Ankit.Simple.Restaurant.Application.model.Menu;
import com.Ankit.Simple.Restaurant.Application.model.Restaurant;
import com.Ankit.Simple.Restaurant.Application.model.categeory.Categeory;
import com.Ankit.Simple.Restaurant.Application.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    Repository restaurantRepository;

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.getRestaurants();
    }
    public Restaurant getRestaurantById(Integer id){
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
                return restaurent;
            }
        }
        return null;
    }
    public String addRestaurent(Restaurant restaurant){
        restaurantRepository.addRestaurent(restaurant);
        return "Restaurent Added..";
    }


    public String updateMenu(Integer id,List<Menu>menuList) {
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
               restaurent.setMenu(menuList);
                return "Menu Changed for Id : "+id;
            }
        }
        return "Invalid Restaurant ID...";
    }
    public String updateopeningHours(Integer id,String newTime) {
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
                restaurent.setOpeningHours(newTime);
                return "Restaurant time Changed for Id : "+id;
            }
        }
        return "Invalid Restaurant ID...";

    }

    public String updateRestaraurantName(Integer id,String newRestaurantName) {
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
                restaurent.setRestaurantName(newRestaurantName);
                return "Restaurant Name Changed for Id : "+id;
            }
        }
        return "Invalid Restaurant ID...";

    }

    public String updateRestaurantAddress(Integer id,String newAddress) {
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
                restaurent.setRestaurantAddress(newAddress);
                return "Restaurant Address Changed for Id : "+id;
            }
        }
        return "Invalid Restaurant ID...";

    }

    public String updateRestaurantPhone(Integer id,String newPhone) {
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
                restaurent.setRestaurantPhone(newPhone);
                return "Restaurant phoneNumber Changed for Id : "+id;
            }
        }
        return "Invalid Restaurant ID...";

    }

    public String updateCategeory(Integer id, Categeory categeory) {
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
                restaurent.setCategeory(categeory);
                return "Restaurant Categeory Changed for Id : "+id;
            }
        }
        return "Invalid Restaurant ID...";

    }

    public String updateStaffCount(Integer id,Integer newStaffAddedCount) {
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
                restaurent.setStaffCount(restaurent.getStaffCount()+newStaffAddedCount);
                return "New StaffCount Added for Id : "+id;
            }
        }
        return "Invalid Restaurant ID...";

    }

    public String updatetableCount(Integer id,Integer newAddedTableCount) {
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
                restaurent.setTableCount(restaurent.getTableCount()+newAddedTableCount);
                return "New TableCount Added for Id : "+id;
            }
        }
        return "Invalid Restaurant ID...";

    }
    public String deleteRestaurent(Integer id){
        List<Restaurant> originalList=getAllRestaurants();
        for(Restaurant restaurent:originalList){
            if(restaurent.getRestaurantId().equals(id)){
                restaurantRepository.deleteReataurant(restaurent);
                return "Restaurant Deleted ...";
            }
        }
        return "Invalid Restaurant ID...";
    }

}
