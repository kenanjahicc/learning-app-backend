package com.teach.me.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "imageUrl")
    private String imageUrl;

    @ElementCollection
    @Column(name = "courses")
    private ArrayList<String> courses;

    @Column(name = "cvUrl")
    private String cvUrl;

    @ElementCollection
    @Column(name = "hobbies")
    private ArrayList<String> hobbies;

    @Column(name = "rating")
    private long rating;

}