package com.example.historydiseases.feature_criteria.repository;

import com.example.historydiseases.feature_criteria.entity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
