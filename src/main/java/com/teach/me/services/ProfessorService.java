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
        return new ProfessorDto(professor.getId(), professor.getFullName(), professor.getImageUrl(), professor.getCourses(), professor.getCvUrl(), professor.getHobbies(), professor.getRating());
    }

    public Professor getEntity(long id) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if (professorOptional.isPresent()) {
            return professorOptional.get();
        }
        throw new RuntimeException("does not exist");
    }
}
