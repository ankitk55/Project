package com.Ankit.EmployeeManagementSystem.Service;

import com.Ankit.EmployeeManagementSystem.Model.Attendence;
import com.Ankit.EmployeeManagementSystem.Model.Employee;
import com.Ankit.EmployeeManagementSystem.Model.HR;
import com.Ankit.EmployeeManagementSystem.Repository.IHrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService {
    @Autowired
    IHrRepo hrRepo;
    @Autowired
    private EmployeeService employeeService;

    public ResponseEntity<String> addHr(HR hr) {
        hrRepo.save(hr);
        return new ResponseEntity<>("HR registered successfully", HttpStatus.ACCEPTED);
    }

    public boolean findHr(String hrEmail) {
        HR hr =hrRepo.findByHrEmail(hrEmail);
        if(hr==null){
            return false;
        }
        return true;
    }

    public ResponseEntity<String> updateEmployee(String hrEmail, Long employeeId, Employee employee) {
        if(findHr(hrEmail)){
            return employeeService.updateEmployee(employeeId,employee);
        }
        return new ResponseEntity<>("You are not registerd as a HR you cant edit employee details ",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> addEmployee(String hrEmail, Employee employee) {
        if(findHr(hrEmail)){
            return employeeService.addEmployee(employee);
        }
        return new ResponseEntity<>("You are not registerd as a HR you cant add employee ",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Employee>> getAllEmployees(String hrEmail) {
        if(findHr(hrEmail)){
           return  employeeService.getAllEmployees();
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<String> addAttandence(Long employeeId, String hrEmail, Attendence attendence) {
        if(findHr(hrEmail)){
            return employeeService.addAttandence(employeeId,attendence);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<String> deleteEmployee(Long employeeId, String hrEmail) {
        if(findHr(hrEmail)){
            return employeeService.deleteEmployee(employeeId);
        }
        return new ResponseEntity<>("You are not registerd as a HR you cant add employee ",HttpStatus.FORBIDDEN);
    }
}
