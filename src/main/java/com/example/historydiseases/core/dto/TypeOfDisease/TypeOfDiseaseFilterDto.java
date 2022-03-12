package com.example.historydiseases.core.dto.TypeOfDisease;

import com.example.historydiseases.core.subpplier.FilterDTO;
import com.example.historydiseases.core.entity.typeOfHospital.Hospital;
import lombok.Data;

@Data
public class TypeOfDiseaseFilterDto extends FilterDTO {


    String nameDiseas; // kasalliklar nomi

    String categoryDiseas;

    Hospital typeOfTreatment;


}
