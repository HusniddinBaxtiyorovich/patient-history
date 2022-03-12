package com.example.historydiseases.core.dto;

import com.example.historydiseases.core.entity.typeOfHospital.HospitalType;
import com.example.historydiseases.core.entity.typeOfDiseaseEntity.TypeOfDisease;
import com.example.historydiseases.core.entity.userHistoryEntity.UserHistory;
import lombok.Data;

import java.util.List;
@Data
public class TypeOfTreatmentDto {

    Long id;

    String NameHospital;

    HospitalType hospitalType;

    List<TypeOfDisease> typeOfDiseases;

    private UserHistory userHistory;
}
