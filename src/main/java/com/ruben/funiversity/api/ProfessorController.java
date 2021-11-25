package com.ruben.funiversity.api;

import com.ruben.funiversity.api.dto.ProfessorDto;
import com.ruben.funiversity.api.dto.UpdateProfessorDto;
import com.ruben.funiversity.api.mapper.ProfessorMapper;
import com.ruben.funiversity.domain.Professor;

import com.ruben.funiversity.exceptions.UnknownProfessorException;
import com.ruben.funiversity.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {

    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;

    @Autowired
    public ProfessorController(ProfessorService professorService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Professor createProfessor(@RequestBody ProfessorDto professorDto) {
        return professorService.save(professorMapper.mapToDomain(professorDto));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDto> getAllProfessors() {
        return professorService.getAllProfessors().stream()
                .map(professorMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/professors/{id}", produces = "application/json")
    public Professor getProfessorById(@PathVariable String id) throws UnknownProfessorException {
        return professorService.getProfessorById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}", produces = "application/json")
    public Professor updateProfessor(@PathVariable String id, @RequestBody UpdateProfessorDto updateProfessorDto) throws UnknownProfessorException {
        Professor professorById = getProfessorById(id);
        professorById.setFirstName(updateProfessorDto.getFirstName());
        professorById.setLastName(updateProfessorDto.getLastName());
        return professorService.save(professorById);
    }


    @DeleteMapping(path = "/professors/{id}", produces = "application/json")
    public void deleteProfessor(@PathVariable String id) {
        professorService.deleteProfessor(id);
    }
}
