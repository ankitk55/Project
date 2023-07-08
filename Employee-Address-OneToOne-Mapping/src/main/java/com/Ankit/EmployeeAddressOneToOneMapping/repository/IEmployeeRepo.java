package com.Ankit.EmployeeAddressOneToOneMapping.repository;

import com.Ankit.EmployeeAddressOneToOneMapping.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepo extends CrudRepository<Employee,Long> {
    @Modifying
    @Query(value = "UPDATE EMPLOYEE SET LAST_NAME = :lastName WHERE ID = :id",nativeQuery = true)
    void updateEmployeeLastNameById(Long id, String lastName);
}
