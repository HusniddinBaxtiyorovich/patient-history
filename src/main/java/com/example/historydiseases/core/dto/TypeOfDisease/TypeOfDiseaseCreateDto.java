package com.example.historydiseases.core.dto.TypeOfDisease;

import com.example.historydiseases.core.entity.profileEntity.util.ProfileRole;
import com.example.historydiseases.core.entity.typeOfHospital.Hospital;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class TypeOfDiseaseCreateDto {

    Long id;

    String nameDiseas; // kasalliklar nomi

    String categoryDiseas;

    LocalDateTime createdDate;

    ProfileRole role;

    Hospital typeOfTreatment;


}
