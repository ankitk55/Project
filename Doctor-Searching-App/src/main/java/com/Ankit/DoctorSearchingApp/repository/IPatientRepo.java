package com.Ankit.DoctorSearchingApp.repository;

import com.Ankit.DoctorSearchingApp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient,Long> {

}
