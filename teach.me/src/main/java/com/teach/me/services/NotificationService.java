package com.teach.me.services;

import com.teach.me.models.NotificationDto;
import com.teach.me.models.entities.Notification;
import com.teach.me.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<NotificationDto> getNotifications(){
        List<Notification> a = notificationRepository.findAll();
        ArrayList<NotificationDto> result = new ArrayList<>();
        for(Notification b:a){
            result.add(new NotificationDto(b.getId(), b.getTitle(),b.getDescription(),b.getTime()));
        }
        return result;
    }
    public NotificationDto getNotification(long id){
        Notification a=notificationRepository.findById(id).get();
        return new NotificationDto(a.getId(),a.getTitle(),a.getDescription(),a.getTime());
    }
    public long getNotificationCount(){
        return notificationRepository.count();
    }
}
