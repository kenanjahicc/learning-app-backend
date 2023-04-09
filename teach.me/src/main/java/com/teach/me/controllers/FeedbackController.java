package com.teach.me.controllers;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/feedback")  // ../feedback --> dolazi se do kontrolera
@RestController()
public class FeedbackController {



    @PostMapping()
    public void createFeedback(){

    }

    @PutMapping("/id")
    public void updateFeedback(long feedbackId){

    }

    @DeleteMapping()
    public void deleteFeedback(long feedbackId){

    }


}
