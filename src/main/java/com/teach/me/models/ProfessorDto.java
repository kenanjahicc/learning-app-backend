package com.teach.me.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

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
}
