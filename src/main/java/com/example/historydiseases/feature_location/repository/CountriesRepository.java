package com.example.historydiseases.feature_location.repository;

import com.example.historydiseases.feature_location.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, String> {
}
