package com.teach.me.controllers;

import com.teach.me.models.ProfessorDto;
import com.teach.me.models.entities.Professor;
import com.teach.me.repositories.ProfessorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {
    private final ProfessorRepository professorRepository;

    public SearchController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping("/search/{search}")
    public List<ProfessorDto> searchForProfessors(@PathVariable String search){
        List<ProfessorDto> listaNova= new ArrayList<>();
        List<Professor> staraLista=professorRepository.findAll();
        for (Professor p:staraLista) {
            if(p.getFullName().startsWith(search)) {
                listaNova.add(new ProfessorDto(p.getId(), p.getFullName(), p.getRating(), p.getCourse().toString(), p.getHobby().toString(), p.getExperience(), p.getDegree(), p.getEmail(), null));
            }
        }
        return listaNova;
    }
}
