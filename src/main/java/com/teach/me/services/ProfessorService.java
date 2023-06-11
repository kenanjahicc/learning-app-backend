package com.teach.me.services;

import com.teach.me.models.ProfessorDto;
import com.teach.me.models.entities.Professor;
import com.teach.me.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    private final HobbyService hobbyService;

    private final CourseService courseService;

    public ProfessorService(ProfessorRepository professorRepository,
                            HobbyService hobbyService,
                            CourseService courseService) {
        this.professorRepository = professorRepository;
        this.hobbyService = hobbyService;
        this.courseService = courseService;
    }

    public ProfessorDto getProfessor(long id) {
        Professor professor = getEntity(id);
        ProfessorDto professorDto = toDto(professor);
        professorDto.setCourse(courseService.getCourseDescription(professor.getCourse().getId()));
        professorDto.setHobby(hobbyService.getHobbyDescription(professor.getHobby().getId()));
        professorDto.setExperience(professor.getExperience());
        professorDto.setDegree(professor.getDegree());
        professorDto.setEmail(professor.getEmail());
        professorDto.setTeaching_style(professor.getStyle());
        return professorDto;
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
        return dto;
    }

}
