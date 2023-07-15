package com.Ankit.Student_model_with_mappings.repository;

import com.Ankit.Student_model_with_mappings.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepo extends JpaRepository<Address,Long> {
}
