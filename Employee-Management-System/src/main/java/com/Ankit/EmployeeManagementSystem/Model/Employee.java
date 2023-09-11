package com.Ankit.EmployeeManagementSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    @NotBlank
    private String employeeName;
    @Email(message = "please enter valid email")
    @Column(unique = true)
    private String employeeEmail;
    @Length(min=10,max = 13,message = "please enter valid phone")
    private  String employeePhone;
    private String department;
    private Long EmployeeSalary;

}
