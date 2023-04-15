package com.teach.me.controllers;

import com.teach.me.models.NotificationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RequestMapping("/notifications")
@RestController
public class NotificationsController {
    @GetMapping
    public ArrayList<NotificationDto> getNotifications(){
        ArrayList<NotificationDto> x=new ArrayList<>();
        NotificationDto y=new NotificationDto(13,"titlo","opis", new Date());
        x.add(y);
        y.setId(20);
        y.setTitle("Naziv");
        x.add(y);
        return x;
    }

}
