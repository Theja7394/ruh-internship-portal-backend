package ruh_internship_portal_backend.example.ruh_internship_portal_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.WeeklyDiaryUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.WeeklyDiaryUpdateService;

@RestController
@CrossOrigin
@RequestMapping("/api/diaryUpdate/weekly")
public class WeeklyDiaryUpdateController {
    @Autowired
    private WeeklyDiaryUpdateService weeklyDiaryUpdateService;
    @PostMapping("/save")
    public String saveWeeklyDiaryUpdate(@RequestBody WeeklyDiaryUpdateDTO weeklyDiaryUpdateDTO) {
         weeklyDiaryUpdateService.saveWeeklyDiaryUpdate(weeklyDiaryUpdateDTO);
            return "save";
    }

    @PutMapping("/update")
    public String updateWeeklyDiaryUpdate(@RequestBody WeeklyDiaryUpdateDTO weeklyDiaryUpdateDTO) {
        String message = weeklyDiaryUpdateService.updateWeeklyDiaryUpdate(weeklyDiaryUpdateDTO);
        return message;
    }
}
