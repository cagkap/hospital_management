package com.hospitalaccounting.patientservice.patient.exception;

public class PatientAlreadyExists extends Throwable {
    public PatientAlreadyExists() {
        System.out.println("Patient already exists");
    }
}
