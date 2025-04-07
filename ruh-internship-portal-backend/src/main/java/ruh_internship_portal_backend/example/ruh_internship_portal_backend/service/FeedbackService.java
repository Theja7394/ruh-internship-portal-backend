package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service;

import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.FeedbackDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.request.FeedbackUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.Feedback;
import java.util.List;

public interface FeedbackService {
    String saveFeedback(FeedbackDTO feedbackDTO);

    String updateFeedback(FeedbackUpdateDTO feedbackUpdateDTO);
    List<Feedback> getAllFeedback();

    List<Feedback> findByScNumber(String scNumber);
}
