package com.Ankit.EmployeeManagementSystem.Controller;

import com.Ankit.EmployeeManagementSystem.Model.Attendence;
import com.Ankit.EmployeeManagementSystem.Model.dto.attendenceDto.GetAttandenceDto;
import com.Ankit.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttendenceController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("monthly/{employeeId}")
        public ResponseEntity<GetAttandenceDto> getAttendence(@PathVariable Long employeeId, @RequestParam Integer month, Integer year){

       return   employeeService.getAttendence(employeeId,month,year);
        }
}
