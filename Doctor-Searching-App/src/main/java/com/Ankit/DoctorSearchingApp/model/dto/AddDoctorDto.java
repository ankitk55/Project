package com.Ankit.DoctorSearchingApp.model.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AddDoctorDto {
    @Length(min = 3)
    private String doctorName;
    @Length(max = 30)
    private String city;
    @Email
    private  String doctorEmail;
    @Length(min = 10,max = 13)
    private String phoneNumber;
    private  String location;

}
