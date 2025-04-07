package ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DailyDiaryUpdateDTO {
    private Long id;
    private String sc_number; // Field name in snake_case
    private Date date; // Using java.util.Date
    private String notes; // Corrected to lowercase 'n'
    private LocalDateTime submittedAt = LocalDateTime.now(); // Using LocalDateTime
}