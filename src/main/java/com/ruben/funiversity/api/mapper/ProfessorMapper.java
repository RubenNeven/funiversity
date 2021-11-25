package com.ruben.funiversity.api.mapper;

import com.ruben.funiversity.api.dto.UpdateProfessorDto;
import com.ruben.funiversity.domain.Professor;
import com.ruben.funiversity.api.dto.ProfessorDto;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorDto mapToDto(Professor professor){
        return new ProfessorDto()
                .setId(professor.getId())
                .setFirstName(professor.getFirstName())
                .setLastName(professor.getLastName());
    }

    public Professor mapToDomain(ProfessorDto professorDto){
        return new Professor(
                professorDto.getFirstName(),
                professorDto.getLastName()
        );
    }

    public ProfessorDto mapTopDto(UpdateProfessorDto updateProfessorDto){
        return new ProfessorDto()
                .setId(updateProfessorDto.getId())
                .setFirstName(updateProfessorDto.getFirstName())
                .setLastName(updateProfessorDto.getLastName());
    }
}
