package com.teach.me.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class NotificationDto {
    private long id;
    private String title;
    private String description;
    private Date time;
}
