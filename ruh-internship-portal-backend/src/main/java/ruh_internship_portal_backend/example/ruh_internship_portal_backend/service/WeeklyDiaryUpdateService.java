package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service;

import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.WeeklyDiaryUpdateDTO;

public interface WeeklyDiaryUpdateService {
    String saveWeeklyDiaryUpdate(WeeklyDiaryUpdateDTO weeklyDiaryUpdateDTO);

    String updateWeeklyDiaryUpdate(WeeklyDiaryUpdateDTO weeklyDiaryUpdateDTO);
}
