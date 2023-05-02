package com.teach.me.controllers;

import com.teach.me.models.NotificationDto;
import com.teach.me.services.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/notification")
@RestController
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("all")
    public List<NotificationDto> getNotifications(){
        return notificationService.getNotifications();
    }
    @GetMapping("/{id}")
    public NotificationDto getNotification(@PathVariable("id") long id){
        return notificationService.getNotification(id);
    }


}
