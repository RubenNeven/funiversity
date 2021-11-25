package com.ruben.funiversity.api.dto;

public class CourseDto {
    private String id;
    private String name;
    private int studyPoints;
    private String professorId;

    public CourseDto() {
    }

    public String getId() {
        return id;
    }

    public CourseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public CourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public String getProfessorId() {
        return professorId;
    }

    public CourseDto setProfessorId(String professorId) {
        this.professorId = professorId;
        return this;
    }
}
