package com.example.historydiseases.feature_criteria.dto;

import com.example.historydiseases.feature_criteria.HospitalType;
import com.example.historydiseases.feature_criteria.entity.TypeOfDisease;
import com.example.historydiseases.feature_criteria.entity.UserHistory;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
public class TypeOfTreatmentDto {

    Long id;

    String NameHospital;

    HospitalType hospitalType;

    List<TypeOfDisease> typeOfDiseases;

    private UserHistory userHistory;
}
