package ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "internship_status")
public class Internship_Status {

    @Id
    @Column(name = "status_id", length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long status_id;

    @Column(name = "sc_number", nullable = false)
    private String sc_number;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_status", nullable = false)
    private Current_status current_status;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    public enum Current_status {
        CALL_FOR_INTERVIEW,
        FACED_INTERVIEW,
        SELECTED,
        INTERN,
        COMPLETED_INTERN;
    }
}
