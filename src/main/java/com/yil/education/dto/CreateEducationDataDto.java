package com.yil.education.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateEducationDataDto {
    @NotBlank
    @Length(min = 1, max = 1000)
    private String name;
    private Integer institutionCode;
    private boolean isActive;
    private Integer educationTypeId;

}
