package com.ruben.funiversity.api.mapper;

import com.ruben.funiversity.api.dto.CourseDto;
import com.ruben.funiversity.domain.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDto mapToDto(Course course) {
      return new CourseDto()
              .setId(course.getId())
              .setName(course.getName())
              .setStudyPoints(course.getStudyPoints())
              .setProfessorId(course.getProfessorId());
    }

    public Course mapToDomain(CourseDto courseDto) {
        return new Course(courseDto.getName(), courseDto.getStudyPoints(), courseDto.getProfessorId());
    }
}
