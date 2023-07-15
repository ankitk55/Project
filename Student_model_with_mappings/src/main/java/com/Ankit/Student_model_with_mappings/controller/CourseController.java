package com.Ankit.Student_model_with_mappings.controller;

import com.Ankit.Student_model_with_mappings.model.Course;
import com.Ankit.Student_model_with_mappings.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("course")
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }
    @GetMapping("courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    @GetMapping("course/{courseId}")
    public Course getCourseById(@PathVariable Long courseId){
        return courseService.getCourseById(courseId);
    }
    @PutMapping("course/{courseId}/{duration}")
    public String updateDuration(@PathVariable Long courseId,@PathVariable String duration){
        return courseService.updateDuration(courseId,duration);
    }
    @DeleteMapping("course/{courseId}")
    public void deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
    }
}
