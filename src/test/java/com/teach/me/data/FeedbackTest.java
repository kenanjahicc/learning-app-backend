package com.teach.me.data;

import com.teach.me.models.FeedbackDto;
import com.teach.me.models.entities.Feedback;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FeedbackTest {
    private static long id1 = 0L;
    private static String title1 = "Complaint";
    private static String courseName1 = "CS360";
    private static String profName1 = "Željko Jurić";
    private static Date date1 = new Date();


    public static Feedback feedback() {
        Feedback feedback = new Feedback();
        feedback.setId(id1);
        feedback.setTitle(title1);
        feedback.setCourseName(courseName1);
        feedback.setProfName(profName1);
        feedback.setDate(date1);
        return feedback;
    }

    public static FeedbackDto feedbackDto1() {
        return new FeedbackDto(id1, title1, courseName1, profName1, date1,  "Professor is OK");
    }

    public static FeedbackDto feedbackDto3() {
        return new FeedbackDto(3L, "Feedback", "OOP", "Edin Fazlic", new Date(), "Everything OK");
    }
}
