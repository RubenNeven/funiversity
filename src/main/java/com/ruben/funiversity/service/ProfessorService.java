package com.ruben.funiversity.service;

import com.ruben.funiversity.domain.Professor;
import com.ruben.funiversity.exceptions.UnknownProfessorException;
import com.ruben.funiversity.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.getAllProfessors();
    }

    public Professor getProfessorById(String id) throws UnknownProfessorException {
        Optional<Professor> professorById = professorRepository.getProfessorById(id);
        if (isPresent(professorById)) {
            return professorById.get();
        } else {
            throw new UnknownProfessorException("Professor with id: " + id + " does not exists");
        }
    }

    public void deleteProfessor(String id) {
        professorRepository.deleteProfessor(id);
    }

    private boolean isPresent(Optional<Professor> professorById) {
        return professorById.isPresent();
    }
}
