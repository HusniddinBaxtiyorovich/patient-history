package com.example.historydiseases.feature_location.endpoints;

import java.util.List;

import com.example.historydiseases.feature_location.entity.Regions;
import com.example.historydiseases.feature_location.repository.RegionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionsRepository repository;

    public Regions getById(String regionId) {
        var regionOptional = repository.findById(regionId);
        if (!regionOptional.isPresent()) {
            return null;
        }
        return regionOptional.get();
    }

    public List<Regions> getRegions() {
        return repository.findAll();
    }

    public Regions addRegion(Regions region) {
        var regions = repository.save(region);
        return regions;
    }

    public List<Regions> addRegions(List<Regions> regions) {
        var regionsResult = repository.saveAll(regions);
        return regionsResult;
    }
}