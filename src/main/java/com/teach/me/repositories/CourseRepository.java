package com.teach.me.repositories;


import com.teach.me.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> getCoursesByProfessorId(long id);
}
