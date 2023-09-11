package com.Ankit.DoctorSearchingApp.controller;

import com.Ankit.DoctorSearchingApp.model.Doctor;
import com.Ankit.DoctorSearchingApp.model.Patient;
import com.Ankit.DoctorSearchingApp.model.Symptoms;
import com.Ankit.DoctorSearchingApp.model.dto.GetDoctorDto;
import com.Ankit.DoctorSearchingApp.model.dto.Locations;
import com.Ankit.DoctorSearchingApp.service.DoctorService;
import com.Ankit.DoctorSearchingApp.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class PatientController {
    @Autowired
    private PatientService patientService;


    @PostMapping("patient")
    public ResponseEntity<String>addPatient(@Valid @RequestBody Patient patient, @RequestParam Symptoms symptoms){
        return patientService.addPatient(patient,symptoms);
    }
    @GetMapping("doctors/{patientId}")
    public ResponseEntity<GetDoctorDto>getDoctors(@PathVariable Long patientId){
        return patientService.getDoctors(patientId);
    }
    @PutMapping("symptom/{patientId}")
    public ResponseEntity<String> updateSymptom(@PathVariable Long patientId,@RequestParam Symptoms select_symtoms){
        return patientService.updateSymptom(patientId,select_symtoms);
    }

    @PutMapping("location/{patientId}")
    public ResponseEntity<String> updateLocation(@PathVariable Long patientId,@RequestParam Locations select_location){
        return patientService.updateLocation(patientId,select_location);
    }
    @DeleteMapping("patient/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId){

        return patientService.deletePatient(patientId);
    }

}
