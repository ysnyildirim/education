package com.yil.education.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto implements Serializable {
    private Long id;
    private String name;
    private Integer institutionCode;
    private boolean isActive;
    private Integer educationTypeId;
}
