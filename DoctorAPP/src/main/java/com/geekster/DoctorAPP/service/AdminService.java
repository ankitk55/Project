package com.geekster.DoctorAPP.service;


import com.geekster.DoctorAPP.model.Admin;
import com.geekster.DoctorAPP.model.Appointment;
import com.geekster.DoctorAPP.model.Doctor;
import com.geekster.DoctorAPP.model.Patient;
import com.geekster.DoctorAPP.repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    PatientService patientService;
    @Autowired
    DoctorService doctorService;

    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    public List<Patient> getAllPatients() {
        return  patientService.getAllPatients();
    }

    public String addAdmin(Admin admin) {
         adminRepo.save(admin);
         return "admin added.";
    }

    public List<Doctor> allDoctors() {
        return doctorService.getAllDoctors();
    }
}
