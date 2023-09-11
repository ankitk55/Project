package com.Ankit.DoctorSearchingApp.repository;

import com.Ankit.DoctorSearchingApp.model.Doctor;
import com.Ankit.DoctorSearchingApp.model.dto.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDoctorRepo extends JpaRepository<Doctor,Long> {
    Doctor findByDoctorEmail(String email);

    List<Doctor> findByLocationAndSpeciality(String location, Speciality speciality);
}
