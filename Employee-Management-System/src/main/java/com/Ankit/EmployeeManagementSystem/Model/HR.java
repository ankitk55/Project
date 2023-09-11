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
public class HR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hrId;
    @NotBlank
    private String hrName;
    @Email(message = "please enter valid email")
    @Column(unique = true)
    private String hrEmail;
    @Length(min=10,max = 13,message = "please enter valid phone")
    private  String hrPhone;
    private String department;
}
