package com.teach.me.services;

import com.teach.me.models.NotificationDto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService {
    public static NotificationDto getNotification(long id){
        return new NotificationDto(id,"TestTitle","TestDesc",new Date());
    }
    public static boolean addNotification(NotificationDto x){
    return true;
    }
}
