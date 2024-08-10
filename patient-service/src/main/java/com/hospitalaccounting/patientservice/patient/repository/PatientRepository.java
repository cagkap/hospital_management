package com.hospitalaccounting.patientservice.patient.repository;

import com.hospitalaccounting.patientservice.patient.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends PagingAndSortingRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {
    List<Patient> findAll();

    boolean existsByIdentityNum(String identityNum);

    void save(Patient patient);
}
