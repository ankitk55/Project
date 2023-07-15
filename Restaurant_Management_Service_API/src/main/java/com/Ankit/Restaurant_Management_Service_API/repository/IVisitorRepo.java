package com.Ankit.Restaurant_Management_Service_API.repository;

import com.Ankit.Restaurant_Management_Service_API.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVisitorRepo extends JpaRepository<Visitor,Long> {
}
