package com.ruben.funiversity.repository;

import com.ruben.funiversity.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private final List<Course> courses;

    public CourseRepository() {
        courses = new ArrayList<>();
    }

    public List<Course> getAllCourses(){
        return courses;
    }

    public Course save(Course course){
        courses.add(course);
        return course;
    }


}
