package com.example.historydiseases.feature_criteria.dto.typeOfTreatment;

import com.example.historydiseases.feature_criteria.HospitalType;
import com.example.historydiseases.feature_criteria.entity.TypeOfDisease;
import com.example.historydiseases.feature_criteria.entity.UserHistory;

import java.util.List;

public class TypeOfTreatmentCreateDto {


    Long id;

    String NameHospital;

    HospitalType hospitalType;

    List<TypeOfDisease> typeOfDiseases;

    private UserHistory userHistory;

}
