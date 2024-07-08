package com.hospitalaccounting.patientservice.common.dto;

import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

@Getter
public class PageRequestDTO {
    // Getters and setters
    private int page;
    private int size;
    private String sortBy;
    private String sortDirection;
    private Map<String, Object> searchCriteria;

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public void setSearchCriteria(Map<String, Object> searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public static class PageRequestBuilder {
        private int page;
        private int size;
        private Sort sort;
        private Map<String, Object> searchCriteria;

        private PageRequestBuilder() {
            this.page = 0; // Default page number
            this.size = 10; // Default page size
            this.sort = Sort.unsorted(); // Default sort
            this.searchCriteria = new HashMap<String, Object>();
        }

        public static PageRequestBuilder of(PageRequestDTO pageRequestDTO) {
            PageRequestBuilder builder = new PageRequestBuilder();
            builder.page = pageRequestDTO.getPage();
            builder.size = pageRequestDTO.getSize();
            if (pageRequestDTO.getSortBy() != null) {
                Sort.Direction direction = Sort.Direction.fromString(pageRequestDTO.getSortDirection());
                builder.sort = Sort.by(direction, pageRequestDTO.getSortBy());
            }


            return builder;
        }

        public PageRequestBuilder withSort(String field) {
            this.sort = Sort.by(Sort.Direction.ASC, field); // Default to ascending order
            return this;
        }

        public PageRequestBuilder withSort(String field, Sort.Direction direction) {
            this.sort = Sort.by(direction, field);
            return this;
        }

        public PageRequest build() {
            return PageRequest.of(page, size, sort);
        }
    }
}
