package com.example.historydiseases.core.dto.typeOfTreatment;

import com.example.historydiseases.core.subpplier.FilterDTO;
import com.example.historydiseases.core.entity.typeOfHospital.HospitalType;
import com.example.historydiseases.core.entity.typeOfDiseaseEntity.TypeOfDisease;
import com.example.historydiseases.core.entity.userHistoryEntity.UserHistory;
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
