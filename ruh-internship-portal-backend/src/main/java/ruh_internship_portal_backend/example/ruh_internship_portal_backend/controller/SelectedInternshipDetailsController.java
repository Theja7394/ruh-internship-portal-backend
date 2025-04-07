package ruh_internship_portal_backend.example.ruh_internship_portal_backend.controller;

import org.springframework.web.bind.annotation.*;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.SelectedInternshipDetailsDTO;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.SelectedInternshipDetailsService;

@RestController
@CrossOrigin
@RequestMapping("/api/internship-selection")
public class SelectedInternshipDetailsController {

    private final SelectedInternshipDetailsService selectedInternshipDetailsService;

    public SelectedInternshipDetailsController(SelectedInternshipDetailsService selectedInternshipDetailsService) {
        this.selectedInternshipDetailsService = selectedInternshipDetailsService;
    }

    @PostMapping("/save")
    public String getSelectedInternshipDetails(@RequestBody SelectedInternshipDetailsDTO selectedInternshipDetailsDTO) {
        selectedInternshipDetailsService.getSelectedInternshipDetails(selectedInternshipDetailsDTO);
        return "save";
    }

    @PutMapping("/update")
    public String updateSelectedInternshipDetails(@RequestBody SelectedInternshipDetailsDTO selectedInternshipDetailsDTO) {
        return selectedInternshipDetailsService.updateSelectedInternshipDetails(selectedInternshipDetailsDTO);
    }
}
