package com.teach.me.controllers;

import com.teach.me.models.FeedbackDto;
import com.teach.me.services.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feedback")  // ../feedback --> dolazi se do kontrolera
@RestController()
public class FeedbackController {

    private final FeedbackService feedbackService;

    FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/{id}")
    public FeedbackDto getFeedback(@PathVariable long id) {
        return feedbackService.getFeedback(id);
    }

    @GetMapping("/{id}/feedbacks")
    public List<FeedbackDto> getFeedbacks(@PathVariable long id){return feedbackService.getFeedbacks(id);}

    @PostMapping
    public FeedbackDto createFeedback(@RequestBody FeedbackDto feedback) {
        return feedbackService.createFeedback(feedback);
    }

    @PutMapping("/{id}")
    public FeedbackDto updateFeedback(@PathVariable long id, @RequestBody FeedbackDto feedback) {
        return feedbackService.updateFeedback(id, feedback);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable long id) {
        feedbackService.deleteFeedback(id);
    }


}
