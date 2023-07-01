package com.Ankit.University.Event.Management.controller;

import com.Ankit.University.Event.Management.model.Student;
import com.Ankit.University.Event.Management.model.departmentType;
import com.Ankit.University.Event.Management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("students")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("student/{id}")
    public Optional<Student> getById(@PathVariable Integer id){
        return studentService.getById(id);
    }
@PostMapping("student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PostMapping("students")
    public String addStudentList(@RequestBody List<Student> studentList){
        return studentService.addStudentList(studentList);
    }

    @PutMapping("student/department/{id}/department/{department}")
    public String updateStudentDepartmentById(@PathVariable Integer id,@PathVariable departmentType department){
        return studentService.updateStudentDepartmentById(id,department);
    }

    @DeleteMapping("student/{id}")
    public String deleteStudentById(@PathVariable  Integer id){
        return studentService.deleteStudentById(id);
    }

}
