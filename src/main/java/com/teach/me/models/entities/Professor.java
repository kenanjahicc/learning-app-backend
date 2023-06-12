package com.teach.me.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

@Entity
@Table(name = "professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    public Professor (String FullName, String Password, String email){
       this.fullName= FullName; this.password= Password; this.email= email;
    }

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

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "bug_report", referencedColumnName = "id")
    private BugReport bugReport;

    @Column(name = "rating")
    private long rating;

    @Column(name = "degree")
    private String degree;

    @Column(name = "experience")
    private String experience;

    @Column(name= "contact")
    private String email;

    @Column(name = "teaching_style")
    private String style;

}