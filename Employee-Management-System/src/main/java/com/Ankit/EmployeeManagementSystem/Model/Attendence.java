package com.Ankit.EmployeeManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Attendence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

   private  LocalDate date;
   private Boolean pesentStatus;
   @ManyToOne
           @JoinColumn(name = "fk_employeeId")
   private Employee employee;
}
