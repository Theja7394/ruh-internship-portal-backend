package ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.Internship_Status;

public interface InternshipStatusRepo extends JpaRepository<Internship_Status, Long> {
}
