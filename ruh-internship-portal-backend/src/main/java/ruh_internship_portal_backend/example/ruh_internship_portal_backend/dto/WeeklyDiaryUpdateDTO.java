package ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeeklyDiaryUpdateDTO {
    private Long id;

    private String sc_number;

    private int weeknumber;

    private String Notes;

    private LocalDateTime submittedAt = LocalDateTime.now();
}
