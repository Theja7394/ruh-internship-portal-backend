package ruh_internship_portal_backend.example.ruh_internship_portal_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.InternshipStatusDto;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.service.InternshipStatusService;

import java.util.List;


@RestController
@RequestMapping("api/internship-status")
public class InternshipServiceController {

    @Autowired
    private InternshipStatusService internshipStatusService;


    @PostMapping
    public ResponseEntity<InternshipStatusDto> createInternshipStatus(@RequestBody InternshipStatusDto dto) {
        return ResponseEntity.ok(internshipStatusService.createInternshipStatus(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInternshipStatus(@PathVariable Long id) {
        internshipStatusService.deleteInternshipStatus(id);
        return ResponseEntity.ok("Internship status deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternshipStatusDto> updateInternshipStatus(@PathVariable Long id, @RequestBody InternshipStatusDto dto) {
        return ResponseEntity.ok(internshipStatusService.updateInternshipStatus(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<InternshipStatusDto>> getInternshipStatus() {
        return ResponseEntity.ok(internshipStatusService.getAllInternshipStatuses());
    }
}
