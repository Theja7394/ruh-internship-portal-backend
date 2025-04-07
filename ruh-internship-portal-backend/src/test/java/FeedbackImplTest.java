package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.Impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.FeedbackDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.request.FeedbackUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.Feedback;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo.FeedbackRepo;

@ExtendWith(MockitoExtension.class)
public class FeedbackImplTest {

    @Mock
    private FeedbackRepo feedbackRepo;

    @InjectMocks
    private FeedbackImpl feedbackService;

    private FeedbackDTO feedbackDTO;
    private FeedbackUpdateDTO feedbackUpdateDTO;
    private Feedback feedback;

    @BeforeEach
    public void setUp() {
        feedbackDTO = new FeedbackDTO();
        feedbackDTO.setFeedback_id(1L);
        feedbackDTO.setSc_number("SC123");
        feedbackDTO.setCompany_name("Company A");
        feedbackDTO.setFeedback("Great experience!");

        feedbackUpdateDTO = new FeedbackUpdateDTO();
        feedbackUpdateDTO.setFeedback_id(1L); // Use Long for feedback_id
        feedbackUpdateDTO.setFeedback("Updated feedback!");

        feedback = new Feedback();
        feedback.setFeedback_id(1L); // Use Long for feedback_id
        feedback.setSc_number("SC123");
        feedback.setCompany_name("Company A");
        feedback.setFeedback("Great experience!");
    }

    @Test
    public void testSaveFeedback_Success() {
        // Act
        String result = feedbackService.saveFeedback(feedbackDTO);

        // Assert
        verify(feedbackRepo).save(any(Feedback.class));
        assertEquals("save", result);
    }

    @Test
    public void testUpdateFeedback_Success() {
        // Arrange
        when(feedbackRepo.existsById(feedbackUpdateDTO.getFeedback_id())).thenReturn(true);
        when(feedbackRepo.getReferenceById(feedbackUpdateDTO.getFeedback_id())).thenReturn(feedback);

        // Act
        String result = feedbackService.updateFeedback(feedbackUpdateDTO);

        // Assert
        verify(feedbackRepo).save(feedback);
        assertEquals("Updated feedback! updated successfully", result);
    }

    @Test
    public void testUpdateFeedback_NotFound() {
        // Arrange
        when(feedbackRepo.existsById(feedbackUpdateDTO.getFeedback_id())).thenReturn(false);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            feedbackService.updateFeedback(feedbackUpdateDTO);
        });

        assertEquals("Feedback not found", exception.getMessage());
        verify(feedbackRepo, never()).save(any());
    }
}