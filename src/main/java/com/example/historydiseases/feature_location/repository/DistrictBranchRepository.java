package com.example.historydiseases.feature_location.repository;

import com.example.historydiseases.feature_location.entity.DistrictBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DistrictBranchRepository extends JpaRepository<DistrictBranch, Long > {

    @Query("FROM DistrictBranch WHERE district.districtId=?1")
    Optional<DistrictBranch> findByDistrictId(String districtId);
}
