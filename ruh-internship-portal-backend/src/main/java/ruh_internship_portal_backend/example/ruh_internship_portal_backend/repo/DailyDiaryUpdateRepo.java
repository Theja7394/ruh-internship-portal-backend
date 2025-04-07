package ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.DailyDiaryUpdate;

@Repository
public interface DailyDiaryUpdateRepo extends JpaRepository<DailyDiaryUpdate, Long> {
}