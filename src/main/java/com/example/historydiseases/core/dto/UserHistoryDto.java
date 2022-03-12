package com.example.historydiseases.core.dto;

import com.example.historydiseases.core.entity.profileEntity.ProfileEntity;
import com.example.historydiseases.core.entity.typeOfHospital.HospitalType;
import com.example.historydiseases.core.entity.typeOfHospital.Hospital;
import lombok.Data;

import java.util.List;
@Data
public class UserHistoryDto {

    Long Id;

    HospitalType address;

    List<Hospital> typeOfTreatment;

    ProfileEntity profile;


}
