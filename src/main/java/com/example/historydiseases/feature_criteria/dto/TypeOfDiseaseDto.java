package com.example.historydiseases.feature_criteria.dto;

import com.example.historydiseases.feature_criteria.entity.TypeOfTreatment;
import com.example.historydiseases.feature_profile.ProfileRole;
import lombok.Data;

import javax.management.relation.Role;
import java.time.LocalDateTime;

@Data
public class TypeOfDiseaseDto {

    Long id;

    String nameDiseas; // kasalliklar nomi

    String categoryDiseas;

    ProfileRole role;

    LocalDateTime createdDate;

    TypeOfTreatment typeOfTreatment;
}
