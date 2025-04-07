package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.InternshipStatusDto;

import java.util.List;


@Service
@Transactional
public interface InternshipStatusService {
    InternshipStatusDto createInternshipStatus(InternshipStatusDto dto);
    void deleteInternshipStatus(Long id);
    InternshipStatusDto updateInternshipStatus(Long id, InternshipStatusDto dto);
    List<InternshipStatusDto> getAllInternshipStatuses();
}
