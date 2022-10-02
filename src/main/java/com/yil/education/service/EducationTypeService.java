package com.yil.education.service;

import com.yil.education.dto.EducationTypeDto;
import com.yil.education.exception.EducationTypeNotFoundException;
import com.yil.education.model.EducationType;
import com.yil.education.repository.EducationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EducationTypeService {
    private final EducationTypeRepository educationTypeRepository;

    public static EducationTypeDto toDto(EducationType educationType) throws NullPointerException {
        if (educationType == null)
            throw new NullPointerException("Education type is null");
        EducationTypeDto dto = new EducationTypeDto();
        dto.setId(educationType.getId());
        dto.setName(educationType.getName());
        return dto;
    }

    public List<EducationType> findAll() {
        return educationTypeRepository.findAll();
    }

    public EducationType findById(Integer id) throws EducationTypeNotFoundException {
        return educationTypeRepository.findById(id).orElseThrow(EducationTypeNotFoundException::new);
    }
}