package ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity(name = "Weekly_Diary_Update")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeeklyDiaryUpdate {
    @Id
    @Column(name = "id",length = 46)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sc_number",nullable = false)
    private String sc_number;
    @Column(name = "weeknumber",nullable = false)
    private int weeknumber;
    @Column(name = "notes",nullable = false)
    private String Notes;
    @Column(name = "submit_at")
    private LocalDateTime submittedAt = LocalDateTime.now();
}
