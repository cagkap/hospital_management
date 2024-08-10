package com.hospitalaccounting.patientservice.patient.service;

import com.hospitalaccounting.patientservice.common.dto.PageRequestDTO;
import com.hospitalaccounting.patientservice.patient.entity.Patient;

import com.hospitalaccounting.patientservice.patient.exception.PatientAlreadyExists;
import com.hospitalaccounting.patientservice.patient.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static com.hospitalaccounting.patientservice.patient.repository.specification.PatientSpecification.byPageRequestDTO;


@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    public Page<Patient> getAllPatients(PageRequestDTO pageRequestDTO){
        var spec = byPageRequestDTO(pageRequestDTO);
        var pageRequest = PageRequestDTO.PageRequestBuilder.of(pageRequestDTO)
                .withSort("id")
                .build();
        return patientRepository.findAll(spec,pageRequest);
    }

    @Transactional
    public void add(Patient patient) throws PatientAlreadyExists {
        checkPatientDoesNotExist(patient.getIdentityNum());
       patientRepository.save(patient);
    }

    private void checkPatientDoesNotExist(String identityNum) throws PatientAlreadyExists {
        if (patientRepository.existsByIdentityNum(identityNum)) {
            throw new PatientAlreadyExists();
        }
    }
}
