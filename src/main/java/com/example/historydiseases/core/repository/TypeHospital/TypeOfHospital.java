package com.example.historydiseases.core.repository.TypeHospital;

import com.example.historydiseases.core.entity.typeOfHospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfHospital extends JpaRepository<Hospital, Long> {
}
