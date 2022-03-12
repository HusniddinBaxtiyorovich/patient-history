package com.example.historydiseases.feature_criteria.dto.typeOfTreatment;

import com.example.historydiseases.core.subpplier.FilterDTO;
import com.example.historydiseases.feature_criteria.HospitalType;
import com.example.historydiseases.feature_criteria.entity.TypeOfDisease;
import com.example.historydiseases.feature_criteria.entity.UserHistory;
import lombok.Data;

import java.util.List;

@Data
public class TypeOfTreatmentFilterDto extends FilterDTO {


    Long id;

    String NameHospital;

    HospitalType hospitalType;

    List<TypeOfDisease> typeOfDiseases;

    private UserHistory userHistory;
}
