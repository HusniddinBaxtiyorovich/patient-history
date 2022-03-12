package com.example.historydiseases.core.repository.userHistoryRepository;

import com.example.historydiseases.core.entity.userHistoryEntity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
