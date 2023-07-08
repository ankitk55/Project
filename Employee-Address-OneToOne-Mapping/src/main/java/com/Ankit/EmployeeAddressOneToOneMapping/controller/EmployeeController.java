package com.Ankit.EmployeeAddressOneToOneMapping.controller;

import com.Ankit.EmployeeAddressOneToOneMapping.model.Address;
import com.Ankit.EmployeeAddressOneToOneMapping.model.Employee;
import com.Ankit.EmployeeAddressOneToOneMapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee){
         employeeService.addEmployee(employee);
    }
    @GetMapping("employees")
    public Iterable<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("employee/firstName/{id}/{firstName}")
    public void updateEmployeeById(@PathVariable Long id,@PathVariable String firstName){
        employeeService.updateEmployeeById(id,firstName);
    }

    @PutMapping("employee/lastName/{id}/{lastName}")
    public void updateEmployeeLastNameById(@PathVariable Long id,@PathVariable String lastName){
        employeeService.updateEmployeeLastNameById(id,lastName);
    }

    @DeleteMapping("employee/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
}
