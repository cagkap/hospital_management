package com.hospitalaccounting.patientservice.patient.controller.mapper;

import com.hospitalaccounting.patientservice.patient.controller.dto.PatientAddDTO;
import com.hospitalaccounting.patientservice.patient.controller.dto.PatientGetResponseDTO;
import com.hospitalaccounting.patientservice.patient.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PatientMapper {

     PatientGetResponseDTO toPatientGetResponseDTO(Patient patient);

     @Mapping(target = "status", constant = "disactive")
     @Mapping(target = "name", source = "patientAddDTO.name")
     @Mapping(target = "surname", source = "patientAddDTO.surname")
     @Mapping(target = "age", source = "patientAddDTO.age")
     @Mapping(target = "identityNum", source = "patientAddDTO.identityNum")
     @Mapping(target = "gender", source = "patientAddDTO.gender")
     @Mapping(target = "phoneNum", source = "patientAddDTO.phoneNum")
     @Mapping(target = "insertion_date", ignore = true)
     @Mapping(target = "id", ignore = true)
     Patient toPatient(PatientAddDTO patientAddDTO);
}
