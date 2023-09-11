package com.Ankit.DoctorSearchingApp.service;

import com.Ankit.DoctorSearchingApp.model.Doctor;
import com.Ankit.DoctorSearchingApp.model.Patient;
import com.Ankit.DoctorSearchingApp.model.Symptoms;
import com.Ankit.DoctorSearchingApp.model.dto.GetDoctorDto;
import com.Ankit.DoctorSearchingApp.model.dto.Locations;
import com.Ankit.DoctorSearchingApp.model.dto.SpecialitYvsSymptons;
import com.Ankit.DoctorSearchingApp.repository.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PatientService {
    @Autowired
    private IPatientRepo patientRepo;
    @Autowired
    private SpecialitYvsSymptons specialitYvsSymptons;

    @Autowired
    private DoctorService doctorService;

    public ResponseEntity<String> addPatient(Patient patient, Symptoms symptoms) {

        patient.setSymptoms(symptoms);
        patientRepo.save(patient);
        return ResponseEntity.ok("Patient Successfully added");

    }

    public ResponseEntity<GetDoctorDto> getDoctors(Long patientId) {
        Patient patient =patientRepo.findById(patientId).orElse(null);
        if(patient==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String patientLocation =patient.getLocation();
        Symptoms symptom =patient.getSymptoms();
        return doctorService.getDoctors(symptom,patientLocation);
    }

    public ResponseEntity<String> updateSymptom(Long patientId, Symptoms symtom) {
        Patient patient =patientRepo.findById(patientId).orElse(null);
        if(patient==null){
            return new ResponseEntity<>("Patient Not found ",HttpStatus.NOT_FOUND);
        }
        patient.setSymptoms(symtom);
        patientRepo.save(patient);
        return new ResponseEntity<>("Symtom changed  ",HttpStatus.OK);
    }

    public ResponseEntity<String> updateLocation(Long patientId, Locations location) {
        Patient patient =patientRepo.findById(patientId).orElse(null);
        if(patient==null){
            return new ResponseEntity<>("Patient Not found ",HttpStatus.NOT_FOUND);
        }
        patient.setLocation(location.toString());
        patientRepo.save(patient);
        return new ResponseEntity<>("Location changed  ",HttpStatus.OK);
    }

    public ResponseEntity<String> deletePatient(Long patientId) {
        Patient patient =patientRepo.findById(patientId).orElse(null);
        if(patient==null){
            return new ResponseEntity<>("Patient Not found ",HttpStatus.NOT_FOUND);
        }
        patientRepo.delete(patient);
        return  ResponseEntity.ok("Patient successfully deleted of id : "+patientId);
    }
}
