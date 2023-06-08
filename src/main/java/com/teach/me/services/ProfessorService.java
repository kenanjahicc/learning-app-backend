package com.teach.me.services;

import com.teach.me.models.ProfessorDto;
import com.teach.me.models.entities.Professor;
import com.teach.me.repositories.CourseRepository;
import com.teach.me.repositories.HobbyRepository;
import com.teach.me.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final HobbyRepository hobbyRepository;
    private final CourseRepository courseRepository;

    public ProfessorService(ProfessorRepository professorRepository, HobbyRepository hobbyRepository, CourseRepository courseRepository) {
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
        this.hobbyRepository = hobbyRepository;
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
        dto.setRating(professor.getRating());
        dto.setHobby(professor.getHobby().getDescription());
        dto.setCourse(professor.getCourse().getName());
        return dto;
    }

}
