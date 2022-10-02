package com.yil.education.repository;

import com.yil.education.model.EducationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTypeRepository extends JpaRepository<EducationType, Integer> {
}
