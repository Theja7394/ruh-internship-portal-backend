package ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.SelectedInternshipDetailsDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.SelectedInternshipDetails;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo.SelectedInternshipDetailsRepo;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.SelectedInternshipDetailsService;

@Service
public class SelectedInternshipDetailsImpl implements SelectedInternshipDetailsService {

    @Autowired
    private SelectedInternshipDetailsRepo selectedInternshipDetailsRepo;

    @Override
    public String getSelectedInternshipDetails(SelectedInternshipDetailsDTO selectedInternshipDetailsDTO) {
        SelectedInternshipDetails selectedInternshipDetails = new SelectedInternshipDetails(
                selectedInternshipDetailsDTO.getSelection_id(),
                selectedInternshipDetailsDTO.getSc_number(),
                selectedInternshipDetailsDTO.getEmail(),
                selectedInternshipDetailsDTO.getPhoneNumber(),
                selectedInternshipDetailsDTO.getCompany(),
                selectedInternshipDetailsDTO.getDesignation(),
                selectedInternshipDetailsDTO.getAppointment_letter_pdf(),
                selectedInternshipDetailsDTO.getStart_date(),
                selectedInternshipDetailsDTO.getEnd_date(),
                selectedInternshipDetailsDTO.getSupervisor_name()
        );
        selectedInternshipDetailsRepo.save(selectedInternshipDetails);
        return "save";
    }

    @Override
    public String updateSelectedInternshipDetails(SelectedInternshipDetailsDTO selectedInternshipDetailsDTO) {
        if (selectedInternshipDetailsRepo.existsById(selectedInternshipDetailsDTO.getSelection_id())) {
            SelectedInternshipDetails existingDetails = selectedInternshipDetailsRepo.getReferenceById(selectedInternshipDetailsDTO.getSelection_id());

            // Update the fields
            existingDetails.setSc_number(selectedInternshipDetailsDTO.getSc_number());
            existingDetails.setEmail(selectedInternshipDetailsDTO.getEmail());
            existingDetails.setPhoneNumber(selectedInternshipDetailsDTO.getPhoneNumber());
            existingDetails.setCompany(selectedInternshipDetailsDTO.getCompany());
            existingDetails.setDesignation(selectedInternshipDetailsDTO.getDesignation());
            existingDetails.setAppointment_letter_pdf(selectedInternshipDetailsDTO.getAppointment_letter_pdf());
            existingDetails.setStart_date(selectedInternshipDetailsDTO.getStart_date());
            existingDetails.setEnd_date(selectedInternshipDetailsDTO.getEnd_date());
            existingDetails.setSupervisor_name(selectedInternshipDetailsDTO.getSupervisor_name());

            // Save the updated entity
            selectedInternshipDetailsRepo.save(existingDetails);
            return selectedInternshipDetailsDTO.getSc_number() + " updated successfully";
        } else {
            throw new RuntimeException("SelectedInternshipDetails not found");
        }
    }
}