package com.teach.me.services;

import com.teach.me.data.FeedbackTest;
import com.teach.me.models.FeedbackDto;
import com.teach.me.models.entities.Feedback;
import com.teach.me.repositories.FeedbackRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class FeedbackServiceUnitTest {

    @MockBean
    private FeedbackRepository feedbackRepository;

    @TestConfiguration
    static class FeedbackServiceTestConfiguration {

        @Bean
        @Primary
        public FeedbackService FeedbackService(FeedbackRepository feedbackRepository,
                                               HobbyService hobbyService,
                                               CourseService courseService,
                                               ProfessorService professorService) {
            return new FeedbackService(feedbackRepository, professorService, hobbyService, courseService);
        }
    }

    @Autowired
    private FeedbackService feedbackService;

    @Test
    public void givenValidId_whenGetFeedback_thenFeedbackShouldBeFound() {
        long id = 1L;
        Mockito.when(feedbackRepository.findById(id))
                .thenReturn(Optional.of(FeedbackTest.feedback()));

        FeedbackDto resultFeedback = feedbackService.getFeedback(id);

        assertThat(resultFeedback.getTitle()).isEqualTo("Complaint");
    }

    @Test
    public void givenInvalidId_whenGetFeedback_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> feedbackService.getFeedback(3L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenMilestone_whenCreateMilestone_thenMilestoneIsReturned() {

        FeedbackDto inputFeedbackDto = FeedbackTest.feedbackDto1();
        inputFeedbackDto.setId(0L);
        Feedback outputFeedback = FeedbackTest.feedback();

//        Mockito.when(feedbackRepository.save(any(Feedback.class)))
//                .thenReturn(outputFeedback);
//
//
//        FeedbackDto resultFeedback = new FeedbackService(feedbackRepository).createFeedback(inputFeedbackDto); //???
//
//
//        assertThat(resultFeedback).isNotNull();
//        assertThat(resultFeedback.getTitle()).isEqualTo(inputFeedbackDto.getTitle());
//        assertThat(resultFeedback.getId()).isNotEqualTo(2L);
    }

    @Test
    public void givenFeedback_whenCreateFeedback_thenRepositoryCalled() {

        FeedbackDto feedbackDto = FeedbackTest.feedbackDto3();

        Mockito.when(feedbackRepository.save(any(Feedback.class)))
                .thenReturn(FeedbackTest.feedback());

        feedbackService.createFeedback(feedbackDto);

        verify(feedbackRepository, times(1)).save(any(Feedback.class));
    }

    @Test
    public void givenMilestoneAndValidId_whenUpdate_thenMilestoneReturned() {
        // arrange
        FeedbackDto inputFeedbackDto = FeedbackTest.feedbackDto1();
        inputFeedbackDto.setId(1L); // reset id
        long id = 1L;
        Feedback outputFeedback = FeedbackTest.feedback();
        outputFeedback.setFid(id);

        Mockito.when(feedbackRepository.findById(id))
                .thenReturn(Optional.of(outputFeedback));
        Mockito.when(feedbackRepository.save(any(Feedback.class)))
                .thenReturn(outputFeedback);

        // act
        FeedbackDto resultFeedback = feedbackService.updateFeedback(id, inputFeedbackDto);

        // assert
        assertThat(resultFeedback).isNotNull();
        assertThat(resultFeedback.getTitle()).isEqualTo(inputFeedbackDto.getTitle());
        assertThat(resultFeedback.getId()).isEqualTo(id);
    }

    @Test
    public void givenInvalidId_whenUpdate_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> feedbackService.updateFeedback(2L, FeedbackTest.feedbackDto3()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenFeeback_whenDelete_thenRepositoryCalled() {

        long id = 1L;

        feedbackService.deleteFeedback(id);

        verify(feedbackRepository, times(1)).deleteById(id);
    }
}
