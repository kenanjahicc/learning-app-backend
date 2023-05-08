package com.teach.me.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class FeedbackDto {
    private Long id;
    private String title;
    private String courseName;
    private String profName;
    private Date date;
    private String content;

}
