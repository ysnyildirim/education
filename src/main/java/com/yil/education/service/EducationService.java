package com.yil.education.service;

import com.yil.education.dto.CreateEducationDataDto;
import com.yil.education.dto.EducationDto;
import com.yil.education.exception.EducationTypeNotFoundException;
import com.yil.education.model.Education;
import com.yil.education.repository.EducationRepository;
import com.yil.education.repository.EducationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class EducationService {
    private final EducationRepository educationRepository;
    private final EducationTypeRepository educationTypeRepository;

    public static EducationDto toDto(Education education) throws NullPointerException {
        if (education == null)
            throw new NullPointerException("Education inform is null");
        EducationDto dto = new EducationDto();
        dto.setId(education.getId());
        dto.setName(education.getName());
        dto.setInstitutionCode(education.getInstitutionCode());
        dto.setActive(dto.isActive());
        dto.setEducationTypeId(education.getEducationTypeId());
        return dto;
    }

    public Education save(CreateEducationDataDto dto, long userId) throws EducationTypeNotFoundException {
        Education education = new Education();
        return getEducationInform(dto, userId, education);
    }

    private Education getEducationInform(CreateEducationDataDto dto, long userId, Education education)
            throws EducationTypeNotFoundException {
        if (!educationTypeRepository.existsById(dto.getEducationTypeId()))
            throw new EducationTypeNotFoundException();
        education.setName(dto.getName());
        education.setInstitutionCode(dto.getInstitutionCode());
        education.setIsActive(dto.isActive());
        education.setEducationTypeId(dto.getEducationTypeId());
        if (education.getEducationId() == null) {
            education.setCreatedUserId(userId);
            education.setCreatedDate(new Date());
        } else {
            education.setLastModifyUserId(userId);
            education.setLastModifyDate(new Date());
        }
        return educationRepository.save(education);
    }

    public Education replace(long id, CreateEducationDataDto dto, long userId) throws EducationTypeNotFoundException {
        Education person = findById(id);
        return getEducationInform(dto, userId, person);
    }

    public Education findById(Long id) throws EducationTypeNotFoundException {
        return educationRepository.findById(id).orElseThrow(EducationTypeNotFoundException::new);
    }

    public Page<Education> findAll(Pageable pageable) {
        return educationRepository.findAll(pageable);
    }

    public boolean existsById(long id) {
        return educationRepository.existsById(id);
    }

    public void delete(Education education) {
        educationRepository.delete(education);
    }
}
