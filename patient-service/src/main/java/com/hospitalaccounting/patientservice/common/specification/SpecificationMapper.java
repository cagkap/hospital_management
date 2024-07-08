package com.hospitalaccounting.patientservice.common.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class SpecificationMapper {
    public static class SpecificationBuilder<T> {

        private Specification<T> specification;

        private SpecificationBuilder() {
            this.specification = Specification.where(null);
        }

        public static <T> SpecificationBuilder<T> newBuilder() {
            return new SpecificationBuilder<>();
        }



        public SpecificationBuilder<T> with(String fieldName, Object value) {
            if (value != null) {
                specification =  specification.and((root, query, criteriaBuilder) ->
                        Objects.equals(value.toString(), "") ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get(fieldName), value));
            }
            return this;
        }

        public Specification<T> build() {
            return specification;
        }
    }
}
