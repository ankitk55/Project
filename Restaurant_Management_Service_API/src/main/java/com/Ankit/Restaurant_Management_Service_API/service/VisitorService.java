package com.Ankit.Restaurant_Management_Service_API.service;

import com.Ankit.Restaurant_Management_Service_API.model.Visitor;
import com.Ankit.Restaurant_Management_Service_API.repository.IVisitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {
    @Autowired
    IVisitorRepo visitorRepo;

    public void addVisitor(Visitor visitor) {
        visitorRepo.save(visitor);
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepo.findAll();
    }
}
