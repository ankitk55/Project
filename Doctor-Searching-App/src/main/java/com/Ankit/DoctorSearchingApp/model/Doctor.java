package com.Ankit.DoctorSearchingApp.model;

import com.Ankit.DoctorSearchingApp.model.dto.Speciality;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    @Length(min = 3)
    private String doctorName;
    @Length(max = 30)
    private String city;
    @Email
    private  String doctorEmail;
    @Length(min = 10,max = 13)
    private String phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Speciality speciality;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> symptoms;
    private  String location;

}
