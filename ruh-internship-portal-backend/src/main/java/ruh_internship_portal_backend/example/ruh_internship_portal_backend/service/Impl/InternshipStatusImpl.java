package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.InternshipStatusDto;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.Internship_Status;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo.InternshipStatusRepo;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.InternshipStatusService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class InternshipStatusImpl implements InternshipStatusService {

    @Autowired
    private InternshipStatusRepo internshipStatusRepo;

    public InternshipStatusImpl(InternshipStatusRepo internshipStatusRepo) {
        this.internshipStatusRepo = internshipStatusRepo;
    }

    @Override
    public InternshipStatusDto createInternshipStatus(InternshipStatusDto dto) {
        Internship_Status status = mapToEntity(dto);
        return mapToDTO(internshipStatusRepo.save(status));
    }

    @Override
    public InternshipStatusDto updateInternshipStatus(Long id, InternshipStatusDto dto) {
        Internship_Status existingStatus = internshipStatusRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship status not found!"));

        existingStatus.setSc_number(dto.getSc_number());
        existingStatus.setCurrent_status(dto.getCurrent_status());
        existingStatus.setUpdated_at(dto.getUpdated_at());

        return mapToDTO(internshipStatusRepo.save(existingStatus));
    }

    @Override
    public List<InternshipStatusDto> getAllInternshipStatuses() {
        return internshipStatusRepo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteInternshipStatus(Long id) {
        Internship_Status status = internshipStatusRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship status not found!"));
        internshipStatusRepo.delete(status);
    }

    private Internship_Status mapToEntity(InternshipStatusDto dto) {
        Internship_Status entity = new Internship_Status();
        entity.setStatus_id(dto.getStatus_id());
        entity.setSc_number(dto.getSc_number());
        entity.setCurrent_status(dto.getCurrent_status());
        entity.setUpdated_at(dto.getUpdated_at());
        return entity;
    }


    private InternshipStatusDto mapToDTO(Internship_Status entity) {
        InternshipStatusDto dto = new InternshipStatusDto();
        dto.setStatus_id(entity.getStatus_id());
        dto.setSc_number(entity.getSc_number());
        dto.setCurrent_status(entity.getCurrent_status());
        dto.setUpdated_at(entity.getUpdated_at());
        return dto;
    }

}
