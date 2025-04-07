package ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedbackUpdateDTO {
    private Long feedback_id;

    private String feedback;
}
