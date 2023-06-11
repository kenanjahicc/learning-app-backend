package com.teach.me.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDto {
    private Long id;
    private String fullName;
    private Long rating;
    private String course;
    private String hobby;
    private String experience;
    private String degree;
    private String email;
    private String teaching_style;
}
