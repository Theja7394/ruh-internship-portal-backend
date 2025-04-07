package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.WeeklyDiaryUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.WeeklyDiaryUpdate;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo.WeeklyDiaryUpdateRepo;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.WeeklyDiaryUpdateService;

@Service
public class WeeklyDiaryUpdateImpl implements WeeklyDiaryUpdateService {

    @Autowired
    private WeeklyDiaryUpdateRepo weeklyDiaryUpdateRepo;

    @Override
    public String saveWeeklyDiaryUpdate(WeeklyDiaryUpdateDTO weeklyDiaryUpdateDTO) {
        WeeklyDiaryUpdate weeklyDiaryUpdate = new WeeklyDiaryUpdate(
                weeklyDiaryUpdateDTO.getId(),
                weeklyDiaryUpdateDTO.getSc_number(),
                weeklyDiaryUpdateDTO.getWeeknumber(),
                weeklyDiaryUpdateDTO.getNotes(),
                weeklyDiaryUpdateDTO.getSubmittedAt()
        );
        weeklyDiaryUpdateRepo.save(weeklyDiaryUpdate);
        return "save";
    }

    @Override
    public String updateWeeklyDiaryUpdate(WeeklyDiaryUpdateDTO weeklyDiaryUpdateDTO) {
        if (weeklyDiaryUpdateRepo.existsById(weeklyDiaryUpdateDTO.getId())) {
            WeeklyDiaryUpdate weeklyDiaryUpdate = weeklyDiaryUpdateRepo.getReferenceById(weeklyDiaryUpdateDTO.getId());
            weeklyDiaryUpdate.setWeeknumber(weeklyDiaryUpdateDTO.getWeeknumber());
            weeklyDiaryUpdate.setNotes(weeklyDiaryUpdateDTO.getNotes());
            weeklyDiaryUpdateRepo.save(weeklyDiaryUpdate);
            return weeklyDiaryUpdateDTO.getSc_number()+ " " + weeklyDiaryUpdateDTO.getNotes() + " note update successfully";
        } else {
            throw new RuntimeException("Weekly Diary Update not found");
        }
    }
}
