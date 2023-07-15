package com.Ankit.Student_model_with_mappings.service;

import com.Ankit.Student_model_with_mappings.model.Laptop;
import com.Ankit.Student_model_with_mappings.model.Student;
import com.Ankit.Student_model_with_mappings.repository.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    ILaptopRepo laptopRepo;

    public void addLaptop(Laptop laptop) {
        laptopRepo.save(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepo.findAll();
    }

    public Laptop getLaptopById(Long laptopId) {
        return laptopRepo.findById(laptopId).orElse(null);
    }

    public String updatePrice(Long laptopId, Integer price) {
        Laptop laptop =laptopRepo.findById(laptopId).orElse(null);
        if(laptop==null){
            return "invalid Laptop id ..";
        }
        laptop.setPrice(price);
        laptopRepo.save(laptop);
        return "price changed for this id : "+laptopId;
    }

    public void deleteLaptop(Long laptopId) {
        laptopRepo.deleteById(laptopId);
    }
}
