package com.example.historydiseases.feature_location.endpoints;


import java.util.List;

import com.example.historydiseases.feature_location.entity.Countries;
import com.example.historydiseases.feature_location.repository.CountriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class CountriesService {
    private final CountriesRepository repository;

    public Countries getById(String countryId) {
        var countryOptional = repository.findById(countryId);
        if (!countryOptional.isPresent()) {
            return null;
        }
        return countryOptional.get();
    }

    public List<Countries> getAllCountries() {
        return repository.findAll();
    }

    public Countries addCountry(Countries country) {
        return repository.save(country);
    }

    public List<Countries> addCountries(List<Countries> countries) {
        return repository.saveAll(countries);
    }
}