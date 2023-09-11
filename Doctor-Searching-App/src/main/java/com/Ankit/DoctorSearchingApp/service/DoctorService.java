package com.Ankit.DoctorSearchingApp.service;

import com.Ankit.DoctorSearchingApp.model.Doctor;
import com.Ankit.DoctorSearchingApp.model.dto.AddDoctorDto;
import com.Ankit.DoctorSearchingApp.model.dto.GetDoctorDto;
import com.Ankit.DoctorSearchingApp.model.dto.SpecialitYvsSymptons;
import com.Ankit.DoctorSearchingApp.model.Symptoms;
import com.Ankit.DoctorSearchingApp.model.dto.Speciality;
import com.Ankit.DoctorSearchingApp.repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorService {
    @Autowired
    private IDoctorRepo doctorRepo;
    @Autowired
    private SpecialitYvsSymptons specialitYvsSymptons;
    @Autowired
    private GetDoctorDto doctorDto;
    public ResponseEntity<String> addDoctor(Speciality speciality, AddDoctorDto doctor) {
    Doctor doctor1 =new Doctor();

        String email =doctor.getDoctorEmail();
        Doctor existingDoctor =doctorRepo.findByDoctorEmail(email);
        if(existingDoctor!=null){
            return new ResponseEntity<>("doctor already registered with this email id : "+email, HttpStatus.FOUND);
        }
        String doctorLocation =doctor.getLocation();
        if(!doctorLocation.equalsIgnoreCase("delhi") && !doctorLocation.equalsIgnoreCase("noida")
                && !doctorLocation.equalsIgnoreCase("faridabad")){
            return ResponseEntity.ok("We are still waiting to expand to your location \n Available Locations only DELHI,FARIDABAD,NOIDA");
        }

        Map<Speciality,String[]> symptom = specialitYvsSymptons.symptomsList();

            String [] sym =symptom.get(speciality);
            List<String>syList= new ArrayList<>();
            Collections.addAll(syList, sym);
           doctor1.setDoctorName(doctor.getDoctorName());
            doctor1.setDoctorEmail(doctor.getDoctorEmail());
            doctor1.setPhoneNumber(doctor.getPhoneNumber());
            doctor1.setCity(doctor.getCity());
            doctor1.setLocation(doctor.getLocation());
            doctor1.setSymptoms(syList);
            doctor1.setSpeciality(speciality);
            doctorRepo.save(doctor1);
            return ResponseEntity.ok("Doctor successfully registered ..");

    }

    public ResponseEntity<GetDoctorDto>getDoctors(Symptoms sympto, String location) {
        Speciality speciality =null;
        Map<Speciality,String[]> symptom = specialitYvsSymptons.symptomsList();
       for(Speciality key:symptom.keySet()) {
           int flag = 0;
           String[] ssympton = symptom.get(key);
           for (String el : ssympton) {
               if (el.equals(sympto.toString().toLowerCase())) {
                   speciality =key;
                   flag = 1;
                   break;
               }
           }
           if (flag == 1) {
               break;
           }
       }
            List<Doctor> doctorList =doctorRepo.findByLocationAndSpeciality(location,speciality);
       if(doctorList.size()==0){
           doctorDto.setMessage("There isn’t any doctor present at your location for your symptom");
           doctorDto.setDoctor(doctorList);
           return ResponseEntity.ok(doctorDto);
       }
       doctorDto.setMessage("Best Doctors based on your Location  and Symtom..");
       doctorDto.setDoctor(doctorList);
            return new ResponseEntity<>(doctorDto,HttpStatus.OK);
       }

    public ResponseEntity<String> deleteDoctor(Long doctorId) {
        Doctor doctor =doctorRepo.findById(doctorId).orElse(null);
        if(doctor==null){
            return new ResponseEntity<>("Doctor not found",HttpStatus.NOT_FOUND);
        }
        doctorRepo.delete(doctor);
        return ResponseEntity.ok("Doctor successfully deleted of id ; "+doctorId);
    }
}
