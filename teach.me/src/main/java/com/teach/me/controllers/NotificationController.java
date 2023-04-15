package com.teach.me.controllers;

import com.teach.me.models.NotificationDto;
import com.teach.me.services.NotificationService;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/notification")
@RestController
public class NotificationController {
    @GetMapping("/{id}")
    public NotificationDto getNotification(@PathVariable long id){
        NotificationDto x = NotificationService.getNotification(5);
        return x;
    }
    @PostMapping
    public boolean postNotification(@RequestBody NotificationDto x){
        return NotificationService.addNotification(x);
    }
    @DeleteMapping("/{id}")
    boolean deleteNotification(@PathVariable long id){
        return true;
    }


}
