package com.geekster.DoctorAPP.controller;


import com.geekster.DoctorAPP.model.Admin;
import com.geekster.DoctorAPP.model.Appointment;
import com.geekster.DoctorAPP.model.Doctor;
import com.geekster.DoctorAPP.model.Patient;
import com.geekster.DoctorAPP.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("appointments")
    public List<Appointment> getAllAppointments(){
        return adminService.getAllAppointments();
    }
    @GetMapping("patients")
    public List<Patient> getAllPatients(){
        return adminService.getAllPatients();
    }
    @PostMapping("admin")
    public String addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }
    @GetMapping("doctors")
    public List<Doctor>allDoctors(){

        return adminService.allDoctors();
    }
}
