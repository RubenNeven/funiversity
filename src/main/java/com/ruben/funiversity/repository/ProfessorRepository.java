package com.ruben.funiversity.repository;

import com.ruben.funiversity.domain.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProfessorRepository {

    private final List<Professor> professors;

    public ProfessorRepository() {
        professors = new ArrayList<>();
    }

    public Professor save(Professor professor){
        professors.add(professor);
        return professor;
    }

    public List<Professor> getAllProfessors(){
        return professors;
    }

    public Optional<Professor> getProfessorById(String id){
        return professors.stream()
                .filter(professor -> professor.getId().equals(id))
                .findFirst();
    }

    public void deleteProfessor(String id) {
        professors.remove(getProfessorById(id));
    }
}
