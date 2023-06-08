package com.teach.me.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "course", referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "hobby", referencedColumnName = "id")
    private Hobby hobby;

    @Column(name = "fullName")
    private String fullName;

    @OneToOne
    @JoinColumn(name = "bug_report", referencedColumnName = "id")
    private BugReport bugReport;

    @Column(name = "rating")
    private long rating;

}