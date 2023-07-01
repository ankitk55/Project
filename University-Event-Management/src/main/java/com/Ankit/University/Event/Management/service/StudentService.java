package com.Ankit.University.Event.Management.service;

import com.Ankit.University.Event.Management.model.Student;
import com.Ankit.University.Event.Management.model.departmentType;
import com.Ankit.University.Event.Management.repository.IstudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IstudentRepo studentRepo;


    public Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getById(Integer id) {
        return studentRepo.findById(id);
    }

    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Student added ";

    }

    public String addStudentList(List<Student> studentList){
        studentRepo.saveAll(studentList);
        return "all Students Added ...";
    }
    public String updateStudentDepartmentById(Integer id, departmentType department){
        Optional<Student> studentOpt =studentRepo.findById(id);
        Student student =null;
        if(studentOpt.isPresent()){
            student =studentOpt.get();
        }
        else{
            return "Id not found..";
        }
        student.setDepartment(department);
        studentRepo.save(student);
        return "Department updated ..";
    }
    public String deleteStudentById(Integer id){
        studentRepo.deleteById(id);
        return "Student Deleted for Id : "+id;

    }

}
