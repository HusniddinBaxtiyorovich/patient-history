package com.example.historydiseases.core.dto.profile;

import com.example.historydiseases.core.entity.profileEntity.ProfileRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProfileImageDto {

    private Long id;


    private Long userId;


    private String photoId;

    private ProfileRequest clientRequest;


    private LocalDateTime created;


    private LocalDateTime modified;

}
