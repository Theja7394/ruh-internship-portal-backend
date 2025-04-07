package ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.Internship_Status;

import java.time.LocalDate;


@Data
public class InternshipStatusDto {
    private Long status_id;
    private String sc_number;
    private Internship_Status.Current_status current_status;
    private LocalDate updated_at;
}
