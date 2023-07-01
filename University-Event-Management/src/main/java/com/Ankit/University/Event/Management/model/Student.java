package com.Ankit.University.Event.Management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
   @Id
   private  Integer studentId;
   @Pattern( regexp ="^[A-Z].*")
   private  String firstName;
   private  String lastName;
 @Min(value = 18)
 @Max(value = 25)
   private  Integer age;
   @Enumerated(EnumType.STRING)
   private  departmentType department;
}
