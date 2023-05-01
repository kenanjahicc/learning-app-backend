package com.teach.me.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "profName")
    private String profName;

    @Column(name = "date")
    private Date date;

    @Column(name = "content")
    private String content;
}