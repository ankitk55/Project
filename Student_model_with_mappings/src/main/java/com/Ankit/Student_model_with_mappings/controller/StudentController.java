package com.Ankit.Student_model_with_mappings.controller;

import com.Ankit.Student_model_with_mappings.model.Student;
import com.Ankit.Student_model_with_mappings.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("student")
    public void addStudent(@RequestBody Student student){
         studentService.addStudent(student);
    }
    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("student/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }
@PutMapping("student/{studentId}/{phNumber}")
    public String updatePhNumber(@PathVariable Long studentId,@PathVariable String phNumber){
        return studentService.updatePhNumber(studentId,phNumber);
}
@DeleteMapping("student/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
}
}
