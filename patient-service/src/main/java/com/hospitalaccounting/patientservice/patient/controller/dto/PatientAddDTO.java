package com.hospitalaccounting.patientservice.patient.controller.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAddDTO {

    private String name;

    private String surname;

    private int age;

    private String identityNum;

    private String gender;

    private String phoneNum;

    private String address;
}
