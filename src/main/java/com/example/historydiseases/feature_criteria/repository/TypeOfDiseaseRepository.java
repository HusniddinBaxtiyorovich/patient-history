package com.example.historydiseases.feature_criteria.repository;

import com.example.historydiseases.feature_criteria.entity.TypeOfDisease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfDiseaseRepository extends JpaRepository<TypeOfDisease, Long> {
}
