package com.example.historydiseases.core.dto;

import com.example.historydiseases.core.entity.typeOfHospital.Hospital;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TypeOfDiseaseDto {

    Long id;

    String nameDiseas; // kasalliklar nomi

    String categoryDiseas;

    ProfileRole role;

    LocalDateTime createdDate;

    Hospital typeOfTreatment;
}
