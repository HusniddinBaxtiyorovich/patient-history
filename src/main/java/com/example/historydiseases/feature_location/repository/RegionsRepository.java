package com.example.historydiseases.feature_location.repository;

import com.example.historydiseases.feature_location.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<Regions, String> {
}
