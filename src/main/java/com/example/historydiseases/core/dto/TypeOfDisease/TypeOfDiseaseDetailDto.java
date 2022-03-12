package com.example.historydiseases.core.dto.TypeOfDisease;

import com.example.historydiseases.core.entity.typeOfHospital.Hospital;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeOfDiseaseDetailDto {

    Long id;

    String nameDiseas; // kasalliklar nomi

    String categoryDiseas;

    ProfileRole role;

    LocalDateTime createdDate;

    Hospital typeOfTreatment;
}
