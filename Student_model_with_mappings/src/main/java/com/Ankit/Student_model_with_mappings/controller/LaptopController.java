package com.Ankit.Student_model_with_mappings.controller;

import com.Ankit.Student_model_with_mappings.model.Laptop;
import com.Ankit.Student_model_with_mappings.model.Student;
import com.Ankit.Student_model_with_mappings.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    @Autowired
    LaptopService laptopService;
    @PostMapping("laptop")
    public void addLaptop(@RequestBody Laptop laptop){
        laptopService.addLaptop(laptop);
    }
    @GetMapping("laptops")
    public List<Laptop> getAllLaptops(){
        return laptopService.getAllLaptops();
    }
    @GetMapping("laptop/{laptopId}")
    public Laptop getLaptopById(@PathVariable Long laptopId){
        return laptopService.getLaptopById(laptopId);
    }
    @PutMapping("laptop/{laptopId}/{price}")
    public String updatePrice(@PathVariable Long laptopId,@PathVariable Integer price){
        return laptopService.updatePrice(laptopId,price);
    }
    @DeleteMapping("laptop/{laptopId}")
    public void deleteLaptop(@PathVariable Long laptopId){
        laptopService.deleteLaptop(laptopId);
    }
}
