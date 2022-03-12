package com.example.historydiseases.converter;

import com.example.historydiseases.feature_criteria.dto.TypeOfDisease.TypeOfDiseaseDetailDto;
import com.example.historydiseases.feature_criteria.entity.TypeOfDisease;

public class TypeOfDiseaseConverter {

    public static TypeOfDiseaseDetailDto toDtoD(TypeOfDisease disease){

        if (disease== null){
            return null;
        }

        TypeOfDiseaseDetailDto dto = new TypeOfDiseaseDetailDto();

        dto.setId(disease.getId());
        dto.setNameDiseas(disease.getNameDiseas());
        dto.setCategoryDiseas(disease.getCategoryDiseas());
        dto.setCreatedDate(disease.getCreatedDate());
        dto.setRole(disease.getRole());

        return dto;


    }
}
