package com.Ankit.Student_model_with_mappings.repository;

import com.Ankit.Student_model_with_mappings.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepo extends JpaRepository<Course,Long> {
}
