package com.teach.me.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class ProfessorDto {

    private Long id;
    private String fullName;
    private String imageUrl;
    private ArrayList<String> courses;
    private String cvUrl;
    private ArrayList<String> hobbies;
    private Long rating;

}
