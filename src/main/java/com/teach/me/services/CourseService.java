package com.teach.me.services;

import com.teach.me.models.entities.Course;
import com.teach.me.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public String getCourseDescription(long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.get().getName();
    }
}
