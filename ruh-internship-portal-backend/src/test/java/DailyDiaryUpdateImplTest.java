package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.Impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.DailyDiaryUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.DailyDiaryUpdate;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo.DailyDiaryUpdateRepo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class DailyDiaryUpdateImplTest {

    @Mock
    private DailyDiaryUpdateRepo dailyDiaryUpdateRepo;

    @InjectMocks
    private DailyDiaryUpdateImpl dailyDiaryUpdateService;

    private DailyDiaryUpdateDTO dailyDiaryUpdateDTO;
    private DailyDiaryUpdate dailyDiaryUpdate;

    @BeforeEach
    public void setUp() {
        dailyDiaryUpdateDTO = new DailyDiaryUpdateDTO();
        dailyDiaryUpdateDTO.setId(1L);
        dailyDiaryUpdateDTO.setSc_number("SC123");
        dailyDiaryUpdateDTO.setDate(Date.from(LocalDateTime.of(2023, 1, 1, 0, 0)
                .atZone(ZoneId.systemDefault()).toInstant()));
        dailyDiaryUpdateDTO.setNotes("Initial notes");
        dailyDiaryUpdateDTO.setSubmittedAt(LocalDateTime.now());

        dailyDiaryUpdate = new DailyDiaryUpdate(
                dailyDiaryUpdateDTO.getId(),
                dailyDiaryUpdateDTO.getSc_number(),
                dailyDiaryUpdateDTO.getDate(),
                dailyDiaryUpdateDTO.getNotes(),
                dailyDiaryUpdateDTO.getSubmittedAt()
        );
    }

    @Test
    public void testSaveDailyDiaryUpdate_Success() {
        String result = dailyDiaryUpdateService.saveDailyDiaryUpdate(dailyDiaryUpdateDTO);
        verify(dailyDiaryUpdateRepo).save(any(DailyDiaryUpdate.class));
        assertEquals("Daily diary update saved successfully.", result);
    }

    @Test
    public void testUpdateDailyDiaryUpdate_Success() {
        when(dailyDiaryUpdateRepo.existsById(dailyDiaryUpdateDTO.getId())).thenReturn(true);
        when(dailyDiaryUpdateRepo.getReferenceById(dailyDiaryUpdateDTO.getId())).thenReturn(dailyDiaryUpdate);

        String result = dailyDiaryUpdateService.updateDailyDiaryUpdate(dailyDiaryUpdateDTO);
        verify(dailyDiaryUpdateRepo).save(dailyDiaryUpdate);
        assertEquals("SC123 note updated successfully.", result);
    }

    @Test
    public void testUpdateDailyDiaryUpdate_NotFound() {
        when(dailyDiaryUpdateRepo.existsById(dailyDiaryUpdateDTO.getId())).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            dailyDiaryUpdateService.updateDailyDiaryUpdate(dailyDiaryUpdateDTO);
        });

        assertEquals("DailyDiaryUpdate not found", exception.getMessage());
        verify(dailyDiaryUpdateRepo, never()).save(any());
    }
}