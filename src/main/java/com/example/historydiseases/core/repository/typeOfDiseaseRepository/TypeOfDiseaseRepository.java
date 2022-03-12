package com.example.historydiseases.core.repository.typeOfDiseaseRepository;

import com.example.historydiseases.core.entity.typeOfDiseaseEntity.TypeOfDisease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfDiseaseRepository extends JpaRepository<TypeOfDisease, Long> {
}
