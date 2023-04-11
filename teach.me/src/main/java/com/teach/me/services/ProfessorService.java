package com.teach.me.services;

import com.teach.me.models.ProfessorDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProfessorService {

    public ProfessorDto getProfessor(long id) {
        ArrayList<String> courses = new ArrayList<>();
        ArrayList<String> hobbies = new ArrayList<>();
        courses.add("Programming C+");
        courses.add("Computer Architecture");
        hobbies.add("Fishing");
        hobbies.add("Reading");
        return new ProfessorDto(id, "Zeljko Juric", "https://ichef.bbci.co.uk/news/999/cpsprodpb/15951/production/_117310488_16.jpg",
                courses, "https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg",
                hobbies, 5L);
    }
}
