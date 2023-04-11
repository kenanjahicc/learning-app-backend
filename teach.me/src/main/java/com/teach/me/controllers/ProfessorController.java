package com.teach.me.controllers;



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
