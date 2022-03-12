package com.example.historydiseases.feature_criteria.dto.TypeOfDisease;

import com.example.historydiseases.core.subpplier.FilterDTO;
import com.example.historydiseases.feature_criteria.entity.TypeOfTreatment;
import lombok.Data;

@Data
public class TypeOfDiseaseFilterDto extends FilterDTO {


    String nameDiseas; // kasalliklar nomi

    String categoryDiseas;

    TypeOfTreatment typeOfTreatment;


}
