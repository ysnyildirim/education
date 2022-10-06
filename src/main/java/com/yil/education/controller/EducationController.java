package com.yil.education.controller;

import com.yil.education.base.ApiConstant;
import com.yil.education.base.Mapper;
import com.yil.education.base.PageDto;
import com.yil.education.dto.CreateEducationDataDto;
import com.yil.education.dto.EducationDto;
import com.yil.education.exception.EducationTypeNotFoundException;
import com.yil.education.model.Education;
import com.yil.education.service.EducationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/edu/v1/educations")

public class EducationController {
    private final EducationService educationService;
    private final Mapper<Education, EducationDto> mapper = new Mapper<>(EducationService::toDto);

    @Operation(summary = "Tüm eğitim bilgilerini getirir.")
    @GetMapping
    public ResponseEntity<PageDto<EducationDto>> findAll(
            @RequestParam(required = false, defaultValue = ApiConstant.PAGE) int page,
            @RequestParam(required = false, defaultValue = ApiConstant.PAGE_SIZE) int size) {
        if (page < 0)
            page = 0;
        if (size <= 0 || size > 1000)
            size = 1000;
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(mapper.map(educationService.findAll(pageable)));
    }

    @Operation(summary = "Yeni bir eğitim bilgisi eklemek için kullanılır.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestHeader(value = ApiConstant.AUTHENTICATED_USER_ID) Long authenticatedUserId,
                                         @Valid @RequestBody CreateEducationDataDto dto) throws EducationTypeNotFoundException {
        educationService.save(dto, authenticatedUserId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Eğitim bilgisi eklendi");
    }

    @Operation(summary = "İd bazlı eğitim bilgisi güncellemek için kullanılır.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity replace(@RequestHeader(value = ApiConstant.AUTHENTICATED_USER_ID) Long authenticatedUserId,
                                  @PathVariable Long id,
                                  @Valid @RequestBody CreateEducationDataDto dto) throws EducationTypeNotFoundException {
        educationService.replace(id, dto, authenticatedUserId);
        return ResponseEntity.ok().body("Eğitim bilgisi güncellendi.");
    }

    @Operation(summary = "İd bazlı eğitim bilgisi silmek için kullanılır.")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> delete(@RequestHeader(value = ApiConstant.AUTHENTICATED_USER_ID) Long authenticatedPersonId,
                                         @PathVariable Long id) throws EducationTypeNotFoundException {
        Education education = educationService.findById(id);
        educationService.delete(education);
        return ResponseEntity.ok("Eğitim datası silindi.");
    }
}
