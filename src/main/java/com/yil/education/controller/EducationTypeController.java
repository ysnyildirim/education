package com.yil.education.controller;

import com.yil.education.base.Mapper;
import com.yil.education.dto.EducationTypeDto;
import com.yil.education.exception.EducationTypeNotFoundException;
import com.yil.education.model.EducationType;
import com.yil.education.service.EducationTypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/edu/v1/education-types")
public class EducationTypeController {
    private final EducationTypeService educationTypeService;
    private final Mapper<EducationType, EducationTypeDto> mapper = new Mapper<>(EducationTypeService::toDto);

    @Cacheable("education-type")
    @Operation(summary = "Tüm eğitim tipi bilgilerini getirir.")
    @GetMapping
    public ResponseEntity<List<EducationTypeDto>> findAll() {
        return ResponseEntity.ok(mapper.map(educationTypeService.findAll()));
    }

    @Operation(summary = "Eğitim tipi bilgilerini id bazlı getirir.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<EducationTypeDto> findById(
            @PathVariable Integer id) throws EducationTypeNotFoundException {
        return ResponseEntity.ok(mapper.map(educationTypeService.findById(id)));
    }
}
