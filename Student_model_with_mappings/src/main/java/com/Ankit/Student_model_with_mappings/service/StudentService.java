package com.Ankit.Student_model_with_mappings.service;

import com.Ankit.Student_model_with_mappings.model.Student;
import com.Ankit.Student_model_with_mappings.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
       return studentRepo.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

    public String updatePhNumber(Long studentId, String phNumber) {
        Student student =studentRepo.findById(studentId).orElse(null);
        if(student ==null){
            return "Invalid student Id ...";
        }
        student.setPhoneNumber(phNumber);
        studentRepo.save(student);
        return "phone number changed for id : "+studentId;
    }

    public void deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
    }
}
