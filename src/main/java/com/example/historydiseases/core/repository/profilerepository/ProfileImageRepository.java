package com.example.historydiseases.core.repository.profilerepository;

import com.example.historydiseases.core.entity.profileEntity.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {
}
