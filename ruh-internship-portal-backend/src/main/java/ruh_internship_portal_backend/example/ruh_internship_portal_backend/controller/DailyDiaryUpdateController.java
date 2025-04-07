package ruh_internship_portal_backend.example.ruh_internship_portal_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.DailyDiaryUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.DailyDiaryUpdateService;

@RestController
@CrossOrigin
@RequestMapping("/api/diaryUpdate/daily")
public class DailyDiaryUpdateController {

    @Autowired
    private DailyDiaryUpdateService dailyDiaryUpdateService;

    @PostMapping("/save")
    public String saveDailyDiaryUpdate(@RequestBody DailyDiaryUpdateDTO dailyDiaryUpdateDTO) {
        return dailyDiaryUpdateService.saveDailyDiaryUpdate(dailyDiaryUpdateDTO);
    }

    @PutMapping("/update")
    public String updateDailyDiaryUpdate(@RequestBody DailyDiaryUpdateDTO dailyDiaryUpdateDTO) {
        return dailyDiaryUpdateService.updateDailyDiaryUpdate(dailyDiaryUpdateDTO);
    }
}