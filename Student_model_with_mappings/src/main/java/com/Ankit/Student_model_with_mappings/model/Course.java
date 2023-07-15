package com.Ankit.Student_model_with_mappings.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String title;
    private String description;
    private String duration;

    @ManyToMany
    @JoinTable(name = "course_student",joinColumns = @JoinColumn(name = "fk_courseId"),inverseJoinColumns = @JoinColumn(name = "fk_studentId"))
    private List<Student> studentList;
}
