package com.teach.me.controllers;

import com.teach.me.models.FeedbackDto;
import com.teach.me.services.FeedbackService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feedback")
@RestController()
@Transactional
public class FeedbackController {

    private final FeedbackService feedbackService;

    FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/{id}")
    public FeedbackDto getFeedback(@PathVariable long id) {
        return feedbackService.getFeedback(id);
    }

    @GetMapping("/{profId}/feedbacks")
    public List<FeedbackDto> getFeedbacks(@PathVariable long profId) {
        return feedbackService.getFeedbacks(profId);
    }

    @PostMapping("/{profId}/feedback")
    public FeedbackDto createFeedback(@PathVariable int profId, @RequestBody FeedbackDto feedback) {
        return feedbackService.createFeedback(profId, feedback);
    }

    @PutMapping("/{id}/edit")
    public FeedbackDto updateFeedback(@PathVariable long id, @RequestBody FeedbackDto feedback) {
        return feedbackService.updateFeedback(id, feedback);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable long id) {
        feedbackService.deleteFeedback(id);
    }


}
