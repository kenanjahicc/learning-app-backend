package com.teach.me.repositories;

import com.teach.me.models.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> getFeedbacksByIdOrderByDateDesc(long id);
}
