package com.Ankit.EmployeeManagementSystem.Controller;

import com.Ankit.EmployeeManagementSystem.Model.Attendence;
import com.Ankit.EmployeeManagementSystem.Model.Employee;
import com.Ankit.EmployeeManagementSystem.Model.HR;
import com.Ankit.EmployeeManagementSystem.Service.EmployeeService;
import com.Ankit.EmployeeManagementSystem.Service.HrService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class HrController {
    @Autowired
    HrService hrService;



    @PostMapping("hr")
    public ResponseEntity<String>addHr(@Valid @RequestBody HR hr){
        if(hr.getDepartment().equals("hr")|| hr.getDepartment().equals("HR")){
            return hrService.addHr(hr);
        }
        return new ResponseEntity<>(" Only HR can register here",HttpStatus.BAD_REQUEST);
    }
    @PostMapping("employee/{hrEmail}")
    public ResponseEntity<String>addEmployee(@Valid @PathVariable String hrEmail, @Valid @RequestBody Employee employee){
        return hrService.addEmployee(hrEmail,employee);
    }
    @PutMapping("employee/update/{employeeId}")
    public ResponseEntity<String>updateEmployee(@Valid @RequestParam String hrEmail,@PathVariable Long employeeId, @Valid @RequestBody Employee employee) {
        return hrService.updateEmployee(hrEmail,employeeId,employee);
    }
    @GetMapping("employees/{hrEmail}")
    public ResponseEntity<List<Employee>>getAllEmployees(@Valid @PathVariable String hrEmail){
        return hrService.getAllEmployees(hrEmail);
    }
    @PostMapping("attendence/{employeeId}")
    public ResponseEntity<String>addAttandence(@PathVariable Long employeeId, @RequestParam @Valid String hrEmail, @RequestBody Attendence attendence){
        return hrService.addAttandence(employeeId,hrEmail,attendence);
    }
    @DeleteMapping("employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee (@PathVariable  Long employeeId, @RequestParam @Valid String hrEmail){
        return hrService.deleteEmployee(employeeId,hrEmail);
    }
}
