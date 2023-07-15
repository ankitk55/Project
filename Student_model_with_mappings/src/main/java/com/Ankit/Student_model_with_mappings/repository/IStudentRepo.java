package com.Ankit.Student_model_with_mappings.repository;

import com.Ankit.Student_model_with_mappings.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student,Long> {
}
