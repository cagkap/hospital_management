package com.hospitalaccounting.patientservice.patient.repository.specification;


import com.hospitalaccounting.patientservice.common.dto.PageRequestDTO;
import com.hospitalaccounting.patientservice.patient.entity.Patient;
import com.hospitalaccounting.patientservice.patient.entity.Patient_;
import jakarta.persistence.criteria.Predicate;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashMap;


@UtilityClass
public class PatientSpecification {

    public static Specification<Patient> byPageRequestDTO(PageRequestDTO pageRequestDTO){
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (pageRequestDTO.getSearchCriteria() == null) {
                pageRequestDTO.setSearchCriteria(new HashMap<>());
            }

            // Add conditions based on the search criteria
            if (pageRequestDTO.getSearchCriteria().containsKey("name")) {
                String name = (String) pageRequestDTO.getSearchCriteria().get("name");
                if (name != null && !name.isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get(Patient_.NAME), "%" + name + "%"));
                }
            }

            if (pageRequestDTO.getSearchCriteria().containsKey("surname")) {
                String surname = (String) pageRequestDTO.getSearchCriteria().get("surname");
                if (surname != null && !surname.isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get(Patient_.SURNAME), "%"+surname+"%"));
                }
            }

            if (pageRequestDTO.getSearchCriteria().containsKey("identityNum")) {
                String identityNum = (String) pageRequestDTO.getSearchCriteria().get("identityNum");
                if (identityNum != null && !identityNum.isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get(Patient_.IDENTITY_NUM), identityNum+"%"));
                }
            }

            return predicate;
        };

    }
    public static Specification<Patient> byPatientIdentityNum(String identityNum) {
        return (root, cq, cb) -> cb.equal(root.get(Patient_.IDENTITY_NUM), identityNum);
    }
}
