package com.Ankit.EmployeeManagementSystem.Repository;

import com.Ankit.EmployeeManagementSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee,Long> {
}
