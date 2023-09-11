package com.Ankit.DoctorSearchingApp.model.dto;

import com.Ankit.DoctorSearchingApp.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class GetDoctorDto {
   private String message ;
   private List<Doctor> doctor;
}
