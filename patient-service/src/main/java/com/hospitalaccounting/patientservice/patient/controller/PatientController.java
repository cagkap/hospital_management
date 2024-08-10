package com.hospitalaccounting.patientservice.patient.controller;


import com.hospitalaccounting.patientservice.common.dto.PageRequestDTO;
import com.hospitalaccounting.patientservice.patient.controller.dto.PatientAddDTO;
import com.hospitalaccounting.patientservice.patient.controller.mapper.PatientMapper;
import com.hospitalaccounting.patientservice.patient.entity.Patient;
import com.hospitalaccounting.patientservice.patient.exception.PatientAlreadyExists;
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

    private final PatientMapper patientMapper;

    @PostMapping("/sorgula")
    public Page<Patient> query(@RequestBody PageRequestDTO pageRequestDTO) {
        return patientService.getAllPatients(pageRequestDTO); //sonra burda pageresponsedto döndürebilirsin
    }

    @PostMapping("/ekle")
    public void add(@RequestBody PatientAddDTO patientAddDTO) throws PatientAlreadyExists {
        var patient = patientMapper.toPatient(patientAddDTO);
        patientService.add(patient);

    }



}
