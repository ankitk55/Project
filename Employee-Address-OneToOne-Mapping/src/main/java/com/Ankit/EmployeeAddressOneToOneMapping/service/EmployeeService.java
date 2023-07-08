package com.Ankit.EmployeeAddressOneToOneMapping.service;

import com.Ankit.EmployeeAddressOneToOneMapping.model.Address;
import com.Ankit.EmployeeAddressOneToOneMapping.model.Employee;
import com.Ankit.EmployeeAddressOneToOneMapping.repository.IEmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    IEmployeeRepo employeeRepo;

    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public Iterable<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }

    public void updateEmployeeById(Long id, String firstName) {
        Optional<Employee> newEmployee = employeeRepo.findById(id);
        Employee emplo = null;
        if (newEmployee.isPresent()) {
            emplo = newEmployee.get();
        } else {
            return;
        }
        emplo.setFirstName(firstName);
        employeeRepo.save(emplo);

    }

    public void updateEmployeeLastNameById(Long id, String lastName) {
        employeeRepo.updateEmployeeLastNameById(id, lastName);
    }
}

