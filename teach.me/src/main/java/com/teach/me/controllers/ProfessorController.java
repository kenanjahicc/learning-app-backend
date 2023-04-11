package com.teach.me.controllers;


import com.teach.me.models.ProfessorDto;
import com.teach.me.services.ProfessorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/profile")
@RestController
public class ProfessorController {

    private final ProfessorService professorService;

    ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/{id}")
    public ProfessorDto getProfessor(@PathVariable long id) {
        return professorService.getProfessor(id);
    }
}
