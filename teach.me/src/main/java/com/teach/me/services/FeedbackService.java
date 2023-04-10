package com.teach.me.services;

import com.teach.me.models.FeedbackDto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FeedbackService {

    public FeedbackDto getFeedback(long id) {
        return new FeedbackDto(id, "Complaint", "Math350", "Zeljko Juric", new Date(), "Everything ok");
    }

    public FeedbackDto createFeedback(FeedbackDto feedback) {
        feedback.setId(156L);
        feedback.setDate(new Date());
        // todo set.professorId() here or just put a name?
        return feedback;
    }

    public FeedbackDto updateFeedback(long id, FeedbackDto feedback) {
        feedback.setId(id);
        return feedback;
    }

    public void deleteFeedback(long id) {
        System.out.println("Deleted feedback with id" + id);
    }
}
