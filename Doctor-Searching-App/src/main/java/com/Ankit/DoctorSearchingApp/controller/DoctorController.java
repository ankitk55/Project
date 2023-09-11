package com.Ankit.DoctorSearchingApp.controller;

import com.Ankit.DoctorSearchingApp.model.Doctor;
import com.Ankit.DoctorSearchingApp.model.Symptoms;
import com.Ankit.DoctorSearchingApp.model.dto.AddDoctorDto;
import com.Ankit.DoctorSearchingApp.model.dto.Speciality;
import com.Ankit.DoctorSearchingApp.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("doctor")
    public ResponseEntity<String> addDoctor(@RequestParam Speciality select_speciality, @Valid @RequestBody AddDoctorDto doctor){
        return doctorService.addDoctor(select_speciality,doctor);
    }
    @DeleteMapping("doctor/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long doctorId){
        return doctorService.deleteDoctor(doctorId);
    }


}
