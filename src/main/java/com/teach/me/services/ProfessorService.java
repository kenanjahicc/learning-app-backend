package com.teach.me.services;

import com.teach.me.models.ProfessorDto;
import com.teach.me.models.entities.Professor;
import com.teach.me.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public ProfessorDto getProfessor(long id) {
        Professor professor = getEntity(id);
        return toDto(professor);
    }

    public Professor getEntity(long id) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if (professorOptional.isPresent()) {
            return professorOptional.get();
        }
        throw new RuntimeException("does not exist");
    }
    private static ProfessorDto toDto(Professor professor) {
        ProfessorDto dto = new ProfessorDto();
        dto.setId(professor.getId());
        dto.setFullName(professor.getFullName());
//        dto.setImageUrl(professor.getImageUrl());
//        dto.setCourses(professor.getCourses());
//        dto.setCvUrl(professor.getCvUrl());
//        dto.setHobbies(professor.getHobbies());
        dto.setRating(professor.getRating());
        return dto;
    }

}
