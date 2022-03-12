package com.example.historydiseases.core.dto.typeOfTreatment;

import com.example.historydiseases.core.entity.typeOfHospital.HospitalType;
import com.example.historydiseases.core.entity.typeOfDiseaseEntity.TypeOfDisease;
import com.example.historydiseases.core.entity.userHistoryEntity.UserHistory;

import java.util.List;

public class TypeOfTreatmentCreateDto {


    Long id;

    String NameHospital;

    HospitalType hospitalType;

    List<TypeOfDisease> typeOfDiseases;

    private UserHistory userHistory;

}
