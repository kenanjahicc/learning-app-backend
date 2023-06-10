package com.teach.me.services;

import com.teach.me.models.BugReportDto;
import com.teach.me.models.FeedbackDto;
import com.teach.me.models.ProfessorDto;
import com.teach.me.models.entities.*;
import com.teach.me.repositories.FeedbackRepository;
import com.teach.me.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    private final ProfessorService professorService;
    private final HobbyService hobbyService;
    private final CourseService courseService;
    public FeedbackService(FeedbackRepository feedbackRepository,
                           ProfessorService professorService,
                           HobbyService hobbyService,
                           CourseService courseService) {
        this.feedbackRepository = feedbackRepository;
        this.professorService = professorService;
        this.hobbyService = hobbyService;
        this.courseService = courseService;
    }

    public FeedbackDto getFeedback(long id) {
        Feedback feedback = getEntity(id);
        FeedbackDto dto =  toDto(feedback);
        dto.setId(feedback.getFid());
        return dto;
    }

    public List<FeedbackDto> getFeedbacks(long id) {
        List<Feedback> feedbacks = feedbackRepository.findAllByProfessorId(id);
        List<FeedbackDto> feedbackDtos = new ArrayList<>();
        for (Feedback f : feedbacks) {
            FeedbackDto dto = toDto(f);
            dto.setId(f.getFid());
            feedbackDtos.add(dto);
        }
        return feedbackDtos;
    }


    public FeedbackDto createFeedback(int profId, FeedbackDto feedbackDto) {
        Professor professor =  professorService.getEntity(profId);
        Feedback feedback = toEntity(feedbackDto);
        feedback.setDate(new Date());
        feedback.setProfessor(professor);
        feedbackRepository.save(feedback);
        feedbackDto.setProfId(feedback.getProfessor().getId());
        feedbackDto.setDate(feedback.getDate());
        return feedbackDto;
    }
    public FeedbackDto createFeedback(FeedbackDto feedbackDto) { // for unit tests
        Feedback feedback = new Feedback();
        feedback.setDate(new Date());
        feedback.setContent(feedbackDto.getContent());
        feedback.setTitle(feedbackDto.getTitle());
        feedbackRepository.save(feedback);
        feedbackDto.setId(feedback.getFid());
        feedbackDto.setDate(feedback.getDate());
        return feedbackDto;
    }

    public FeedbackDto updateFeedback(long id, FeedbackDto feedbackDto) {
        Feedback feedback = getEntity(id);
        feedback.setContent(feedbackDto.getContent());
        feedback.setTitle(feedbackDto.getTitle());
        feedbackRepository.save(feedback);
        feedbackDto.setId(feedback.getFid());
        feedbackDto.setDate(feedback.getDate());
        feedbackDto.setProfId(feedback.getProfessor().getId());
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
        feedbackDto.setTitle(feedback.getTitle());
        feedbackDto.setDate(feedback.getDate());
        feedbackDto.setContent(feedback.getContent());
        feedbackDto.setProfId(feedback.getProfessor().getId());
        return feedbackDto;
    }

    private static Feedback toEntity(FeedbackDto feedbackDto){
        Feedback feedback = new Feedback();
        feedback.setTitle(feedbackDto.getTitle());
        feedback.setContent(feedbackDto.getContent());
        return feedback;
    }
}
