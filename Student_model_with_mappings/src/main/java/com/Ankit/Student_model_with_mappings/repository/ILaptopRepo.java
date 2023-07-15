package com.Ankit.Student_model_with_mappings.repository;

import com.Ankit.Student_model_with_mappings.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaptopRepo extends JpaRepository<Laptop,Long> {
}
