package com.teach.me.controllers;

import com.teach.me.models.ProfessorDto;
import com.teach.me.models.entities.Professor;
import com.teach.me.models.entities.UserEntity;
import com.teach.me.repositories.ProfessorRepository;
import com.teach.me.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {
    private final ProfessorRepository professorRepository;
    private final UserRepository userRepository;
    public SearchController(ProfessorRepository professorRepository, UserRepository userRepository) {
        this.professorRepository = professorRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/search/{search}")
    public List<ProfessorDto> searchForProfessors(@PathVariable String search){
        List<ProfessorDto> listaNova= new ArrayList<>();
        List<Professor> staraLista=professorRepository.findAll();

        for (Professor p:staraLista) {
            if(p.getFullName().contains(search)) {
                listaNova.add(new ProfessorDto(p.getId(), p.getFullName(), p.getRating(), p.getCourse().toString(), p.getHobby().toString(), p.getExperience(), p.getDegree(), p.getEmail(), null));
            }
        }

        for (UserEntity us: userRepository.findAll()) {
            if (us.getUsername().contains(search))
            listaNova.add(new ProfessorDto(us.getUsername(),us.getEmail()));
        }


        return listaNova;
    }
}
