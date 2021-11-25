package com.ruben.funiversity.service;

import com.ruben.funiversity.domain.Course;
import com.ruben.funiversity.exceptions.UnknownProfessorException;
import com.ruben.funiversity.repository.CourseRepository;
import com.ruben.funiversity.repository.ProfessorRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CourseService {

    private final CourseRepository courseRepository;
    private final ProfessorService professorService;

    public CourseService(CourseRepository courseRepository, ProfessorService professorService) {
        this.courseRepository = courseRepository;
        this.professorService = professorService;
    }

    public List<Course> getAllCourses(){
        return courseRepository.getAllCourses();
    }

    public Course save(Course course) throws UnknownProfessorException {
        professorService.getProfessorById(course.getProfessorId());
        courseRepository.save(course);
        return course;
    }
}
