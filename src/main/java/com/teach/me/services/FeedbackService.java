package com.teach.me.services;

import com.teach.me.models.FeedbackDto;
import com.teach.me.models.ProfessorDto;
import com.teach.me.models.entities.Feedback;
import com.teach.me.models.entities.Professor;
import com.teach.me.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public FeedbackDto getFeedback(long id) {
        Feedback feedback = getEntity(id);
        return new FeedbackDto(feedback.getId(), feedback.getTitle(), feedback.getDate(), feedback.getContent());
    }
    public List<FeedbackDto> getFeedbacks(long id){
        List<Feedback> feedbacks = feedbackRepository.getFeedbacksByIdOrderByDateDesc(id);
        List<FeedbackDto> feedbackDtos = new ArrayList<>();
        for (Feedback f: feedbacks) {
            feedbackDtos.add(toDto(f));
        }
        return feedbackDtos;
    }

    public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setDate(feedbackDto.getDate());
        feedback.setContent(feedbackDto.getContent());
        feedback.setTitle(feedbackDto.getTitle());
        feedbackRepository.save(feedback);
        feedbackDto.setId(feedback.getId());
        return feedbackDto;
    }

    public FeedbackDto updateFeedback(long id, FeedbackDto feedbackDto) {
        Feedback feedback = getEntity(id);
        feedback.setDate(feedbackDto.getDate());
        feedback.setContent(feedbackDto.getContent());
        feedback.setTitle(feedbackDto.getTitle());
        feedbackRepository.save(feedback);
        return feedbackDto;
    }

    public void deleteFeedback(long id) {
        feedbackRepository.deleteById(id);
    }

    public Feedback getEntity(long id) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);
        if (feedbackOptional.isPresent()) {
            return feedbackOptional.get();
        }
        throw new RuntimeException("does not exist");
    }
    private static FeedbackDto toDto(Feedback feedback) {
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setId(feedback.getId());
        feedbackDto.setTitle(feedback.getTitle());
        feedbackDto.setDate(feedback.getDate());
        feedbackDto.setContent(feedback.getContent());
        return feedbackDto;
    }
}
