package ruh_internship_portal_backend.example.ruh_internship_portal_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.FeedbackDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.request.FeedbackUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.FeedbackService;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.Feedback;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/save")
    public String saveFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        feedbackService.saveFeedback(feedbackDTO);
        return "save";
    }
    @GetMapping
    public String HelloWorld() {

        return "Hello World";
    }

    @PutMapping("/update")
    public String updateFeedback(@RequestBody FeedbackUpdateDTO feedbackUpdateDTO) {
        String message = feedbackService.updateFeedback(feedbackUpdateDTO);
        return message;
    }
    @GetMapping("/all")
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Feedback>> searchFeedbackByScNumber(@RequestParam String scNumber) {
        List<Feedback> feedbackList = feedbackService.findByScNumber(scNumber);
        return ResponseEntity.ok(feedbackList);
    }

}
