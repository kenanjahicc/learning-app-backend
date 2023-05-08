package com.teach.me.services;

import com.teach.me.models.FeedbackDto;
import com.teach.me.models.entities.Feedback;
import com.teach.me.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public FeedbackDto getFeedback(long id) {
        Feedback feedback = feedbackRepository.getById(id);
        return new FeedbackDto(feedback.getId(), feedback.getTitle(), feedback.getCourseName(), feedback.getProfName(), feedback.getDate(), feedback.getContent());
    }

    public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setProfName(feedbackDto.getProfName());
        feedback.setDate(feedbackDto.getDate());
        feedback.setContent(feedbackDto.getContent());
        feedback.setTitle(feedbackDto.getTitle());
        feedback.setCourseName(feedbackDto.getCourseName());
        feedbackRepository.save(feedback);
        feedbackDto.setId(feedback.getId());
        return feedbackDto;
    }

    public FeedbackDto updateFeedback(long id, FeedbackDto feedbackDto) {
        Feedback feedback = feedbackRepository.getById(id);
        feedback.setProfName(feedbackDto.getProfName());
        feedback.setDate(feedbackDto.getDate());
        feedback.setContent(feedbackDto.getContent());
        feedback.setTitle(feedbackDto.getTitle());
        feedback.setCourseName(feedbackDto.getCourseName());
        feedbackRepository.save(feedback);
        return feedbackDto;
    }

    public void deleteFeedback(long id) {
        feedbackRepository.deleteById(id);
    }
}
