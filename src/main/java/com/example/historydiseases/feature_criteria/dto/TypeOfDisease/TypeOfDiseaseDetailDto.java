package com.example.historydiseases.feature_criteria.dto.TypeOfDisease;

import com.example.historydiseases.feature_criteria.entity.TypeOfTreatment;
import com.example.historydiseases.feature_profile.ProfileRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TypeOfDiseaseDetailDto {

    Long id;

    String nameDiseas; // kasalliklar nomi

    String categoryDiseas;

    ProfileRole role;

    LocalDateTime createdDate;

    TypeOfTreatment typeOfTreatment;
}
