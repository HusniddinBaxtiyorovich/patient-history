package com.example.historydiseases.feature_location.dto;

import com.example.historydiseases.feature_location.entity.Regions;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CreateDistrictBranchDTO {
    private List<DistrictBranchDTO> districts;
    //
    //
    private String districtId;

    private Regions region;

    private Map<String, String> name = new HashMap<>();
}
