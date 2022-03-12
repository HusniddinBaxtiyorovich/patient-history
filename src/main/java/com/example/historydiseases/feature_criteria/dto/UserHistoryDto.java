package com.example.historydiseases.feature_criteria.dto;

import com.example.historydiseases.core.entity.Profile;
import com.example.historydiseases.feature_criteria.HospitalType;
import com.example.historydiseases.feature_criteria.entity.TypeOfTreatment;
import lombok.Data;

import java.util.List;
@Data
public class UserHistoryDto {

    Long Id;

    HospitalType address;

    List<TypeOfTreatment> typeOfTreatment;

    Profile profile;


}
