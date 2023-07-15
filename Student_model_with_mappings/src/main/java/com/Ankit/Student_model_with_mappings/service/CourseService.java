package com.Ankit.Student_model_with_mappings.service;

import com.Ankit.Student_model_with_mappings.model.Course;
import com.Ankit.Student_model_with_mappings.repository.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    ICourseRepo courseRepo;

    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseById(Long courseId) {
        return courseRepo.findById(courseId).orElse(null);
    }

    public String updateDuration(Long courseId, String duration) {
        Course course = courseRepo.findById(courseId).orElse(null);
        if(course ==null){
            return "invalid course id ..";
        }
        course.setDuration(duration);
        courseRepo.save(course);
        return "course duration changed for this course id : "+courseId;
    }

    public void deleteCourse(Long courseId) {
        courseRepo.deleteById(courseId);
    }
}
