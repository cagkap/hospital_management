package com.hospitalaccounting.patientservice.patient.controller;


import com.hospitalaccounting.patientservice.common.dto.PageRequestDTO;
import com.hospitalaccounting.patientservice.patient.entity.Patient;
import com.hospitalaccounting.patientservice.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@CrossOrigin
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/sorgula")
    public Page<Patient> sorgula(@RequestBody PageRequestDTO pageRequestDTO) {
        return patientService.getAllPatients(pageRequestDTO);
    }

}
