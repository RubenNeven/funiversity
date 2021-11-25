package com.ruben.funiversity.domain;

import java.util.UUID;

public class Course {
    private final String id;
    private String name;
    private int studyPoints;
    private String professorId;

    public Course(String name, int studyPoints, String professorId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        setStudyPoints(studyPoints);
        this.professorId = professorId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(int studyPoints) {
        if (!isValidStudyPoint(studyPoints)){
            throw new IllegalArgumentException("Not a valid study point. Please enter a number between 1 and 6");
        }
        this.studyPoints = studyPoints;
    }

    private boolean isValidStudyPoint(int studyPoints) {
        return studyPoints > 0 && studyPoints <= 6;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessor(String professorId) {
        this.professorId = professorId;
    }
}
