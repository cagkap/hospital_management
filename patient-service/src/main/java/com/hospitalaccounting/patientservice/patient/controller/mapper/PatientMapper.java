package com.hospitalaccounting.patientservice.patient.controller.mapper;

import com.hospitalaccounting.patientservice.patient.controller.dto.PatientGetResponseDTO;
import com.hospitalaccounting.patientservice.patient.entity.Patient;
import org.mapstruct.Mapper;

@Mapper
public interface PatientMapper {

     PatientGetResponseDTO toPatientGetResponseDTO(Patient patient);
}
