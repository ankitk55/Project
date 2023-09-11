package com.Ankit.EmployeeManagementSystem.Service;

import com.Ankit.EmployeeManagementSystem.Model.Attendence;
import com.Ankit.EmployeeManagementSystem.Model.Employee;
import com.Ankit.EmployeeManagementSystem.Model.dto.attendenceDto.AttandenceDto;
import com.Ankit.EmployeeManagementSystem.Model.dto.attendenceDto.GetAttandenceDto;
import com.Ankit.EmployeeManagementSystem.Repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepo employeeRepo;
    @Autowired
    private AttendenceService attendenceService;

    @Autowired
    private GetAttandenceDto getAttandenceDto;
    public ResponseEntity<String> addEmployee( Employee employee) {

            employeeRepo.save(employee);
            return new ResponseEntity<>("Employee added Successfully", HttpStatus.ACCEPTED);
        }



    public ResponseEntity<String> updateEmployee( Long employeeId, Employee employee) {

           Employee employeee =employeeRepo.findById(employeeId).orElse(null);
           if(employeee==null){
               return new ResponseEntity<>("Invalid Employee id ",HttpStatus.NOT_FOUND);
           }
           if(employee.getEmployeeEmail()!=null){
               employeee.setEmployeeEmail(employee.getEmployeeEmail());
           }
           else if(employee.getEmployeeName()!=null){
               employeee.setEmployeeName(employee.getEmployeeName());
           }
           else if(employee.getEmployeePhone()!=null){
               employeee.setEmployeePhone(employee.getEmployeePhone());
           }
           else if(employee.getDepartment()!=null){
               employeee.setDepartment(employee.getDepartment());
           }
           else if(employee.getEmployeeSalary()!=null){
               employeee.setEmployeeSalary(employee.getEmployeeSalary());
           }
           employeeRepo.save(employeee);

            return new ResponseEntity<>("Employee details updated Successfully", HttpStatus.ACCEPTED);


    }

    public ResponseEntity<List<Employee>> getAllEmployees() {

            List<Employee> employeeList =employeeRepo.findAll();
            return ResponseEntity.ok(employeeList);
        }



    public ResponseEntity<Employee> getEmployee(Long id,String email) {
        Employee employee = employeeRepo.findById(id).orElse(null);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!employee.getEmployeeEmail().equals(email)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(employee);

    }

    public ResponseEntity<String> updateEmployeeDetails(String email, Long id, Employee employee) {
        Employee employee1 =employeeRepo.findById(id).orElse(null);
        if (employee1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!employee1.getEmployeeEmail().equals(email)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return updateEmployee(id,employee);
    }

    public ResponseEntity<String> addAttandence(Long employeeId, Attendence attendence) {
        Employee employee1 =employeeRepo.findById(employeeId).orElse(null);
        if (employee1 == null) {
            return new ResponseEntity<>("User not found ",HttpStatus.NOT_FOUND);
        }
        return attendenceService.addAttandence(employee1,attendence);
    }

    public ResponseEntity<GetAttandenceDto> getAttendence(Long employeeId, Integer monthNam, Integer year) {
        List<AttandenceDto>attandenceList =new ArrayList<>();
        LocalDate date =LocalDate.now();
        int year1 =date.getYear();
        int mont =date.getMonthValue();
        if(year1<year || monthNam>12 ||monthNam<1){
            getAttandenceDto.setMessage("Please Insert valid Date ..  ");
            getAttandenceDto.setTotalAbsent(0);
            getAttandenceDto.setTotalWorkingDays(0);
            getAttandenceDto.setTotalPresent(0);
            getAttandenceDto.setAttandenceList(null);

            return new ResponseEntity<>(getAttandenceDto,HttpStatus.BAD_REQUEST);
        }
        else {
            if(year==year1 && monthNam>mont){
                getAttandenceDto.setMessage("Please Insert valid Date ..  ");
                getAttandenceDto.setTotalAbsent(0);
                getAttandenceDto.setTotalWorkingDays(0);
                getAttandenceDto.setTotalPresent(0);
                getAttandenceDto.setAttandenceList(null);

                return new ResponseEntity<>(getAttandenceDto,HttpStatus.BAD_REQUEST);
            }
        }
        Employee employee1 =employeeRepo.findById(employeeId).orElse(null);
        if (employee1 == null) {
            getAttandenceDto.setMessage("User Not Found.. for this id : "+employeeId);
            getAttandenceDto.setTotalAbsent(0);
            getAttandenceDto.setTotalPresent(0);
            getAttandenceDto.setTotalWorkingDays(0);
            getAttandenceDto.setAttandenceList(null);

            return new ResponseEntity<>(getAttandenceDto,HttpStatus.NOT_FOUND);
        }
        return attendenceService.getAttendence(employee1,monthNam,year,attandenceList);
    }

    public ResponseEntity<String> deleteEmployee(Long employeeId) {
        Employee employee1 =employeeRepo.findById(employeeId).orElse(null);
        if (employee1 == null) {
            return new ResponseEntity<>("Employee not found ,.",HttpStatus.NOT_FOUND);
        }
        attendenceService.deleteAttandence(employee1);
        employeeRepo.delete(employee1);
        return ResponseEntity.ok("Employee Deleted successfully ");

    }
}
