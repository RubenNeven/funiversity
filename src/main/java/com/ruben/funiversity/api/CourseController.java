package com.ruben.funiversity.api;

import com.ruben.funiversity.api.dto.CourseDto;
import com.ruben.funiversity.api.mapper.CourseMapper;
import com.ruben.funiversity.domain.Course;
import com.ruben.funiversity.exceptions.UnknownProfessorException;
import com.ruben.funiversity.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody CourseDto courseDto) {
        try {
            return courseService.save(courseMapper.mapToDomain(courseDto));
        } catch (UnknownProfessorException e) {
            System.out.println(e.getMessage() + " Exception Class" + e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses().stream()
                .map(courseMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
