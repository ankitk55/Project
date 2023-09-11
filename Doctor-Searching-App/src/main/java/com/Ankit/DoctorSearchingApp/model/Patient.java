package com.Ankit.DoctorSearchingApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.security.PrivateKey;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long patientId;
    @Length(min = 3)
   private String patientName;
   private String location;
   @Length(max =20)
   private  String city;
   @Email
   private String patientEmail;
   @Length(min = 10,max = 13)
   private  String patientPhone;
   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   private Symptoms symptoms;
}
