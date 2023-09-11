package com.Ankit.EmployeeManagementSystem.Controller;

import com.Ankit.EmployeeManagementSystem.Model.Employee;
import com.Ankit.EmployeeManagementSystem.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("profile/{id}")
    public ResponseEntity<Employee>getEmployee(@Valid @PathVariable Long id, @RequestParam String email){
        return employeeService.getEmployee(id,email);
    }
    @PutMapping("employee/{id}")
    public ResponseEntity<String>updateEmployeeDetails(@Valid @RequestParam String email,@PathVariable Long id, @Valid @RequestBody Employee employee) {
        return employeeService.updateEmployeeDetails(email,id,employee);
    }
}
