package ruh_internship_portal_backend.example.ruh_internship_portal_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectInternshipDetailsUpdateDTO {
    private String email;

    private String phoneNumber;

    private String supervisor_name;
}
