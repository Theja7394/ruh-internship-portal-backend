package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.WeeklyDiaryUpdateDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.WeeklyDiaryUpdate;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo.WeeklyDiaryUpdateRepo;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class WeeklyDiaryUpdateImplTest {

    @InjectMocks
    private WeeklyDiaryUpdateImpl weeklyDiaryUpdateService;

    @Mock
    private WeeklyDiaryUpdateRepo weeklyDiaryUpdateRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveWeeklyDiaryUpdate() {
        WeeklyDiaryUpdateDTO dto = new WeeklyDiaryUpdateDTO(1L, "SC123", 1, "Test notes", LocalDateTime.now());

        String result = weeklyDiaryUpdateService.saveWeeklyDiaryUpdate(dto);

        assertEquals("save", result);
        verify(weeklyDiaryUpdateRepo, times(1)).save(any(WeeklyDiaryUpdate.class));
    }

    @Test
    void testUpdateWeeklyDiaryUpdate_Success() {
        WeeklyDiaryUpdateDTO dto = new WeeklyDiaryUpdateDTO(1L, "SC123", 2, "Updated notes", LocalDateTime.now());
        WeeklyDiaryUpdate existingUpdate = new WeeklyDiaryUpdate(1L, "SC123", 1, "Old notes", LocalDateTime.now());

        when(weeklyDiaryUpdateRepo.existsById(dto.getId())).thenReturn(true);
        when(weeklyDiaryUpdateRepo.getReferenceById(dto.getId())).thenReturn(existingUpdate);

        String result = weeklyDiaryUpdateService.updateWeeklyDiaryUpdate(dto);

        assertEquals("SC123 Updated notes note update successfully", result);
        verify(weeklyDiaryUpdateRepo, times(1)).save(existingUpdate);
        assertEquals(2, existingUpdate.getWeeknumber());
        assertEquals("Updated notes", existingUpdate.getNotes());
    }

    @Test
    void testUpdateWeeklyDiaryUpdate_NotFound() {
        WeeklyDiaryUpdateDTO dto = new WeeklyDiaryUpdateDTO(1L, "SC123", 2, "Updated notes", LocalDateTime.now());

        when(weeklyDiaryUpdateRepo.existsById(dto.getId())).thenReturn(false);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            weeklyDiaryUpdateService.updateWeeklyDiaryUpdate(dto);
        });

        assertEquals("Weekly Diary Update not found", exception.getMessage());
        verify(weeklyDiaryUpdateRepo, never()).save(any());
    }
}