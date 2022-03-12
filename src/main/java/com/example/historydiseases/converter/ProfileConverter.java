package com.example.historydiseases.converter;

import com.example.historydiseases.core.dto.profile.ProfileDetailDTO;
import com.example.historydiseases.core.entity.profileEntity.ProfileEntity;

public class ProfileConverter {


    public static ProfileDetailDTO toDTO(ProfileEntity entity) {
        if (entity == null)
            return null;

        ProfileDetailDTO dto = new ProfileDetailDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setContact(entity.getContact());
        dto.setStatus(entity.getStatus());
        dto.setAddress(entity.getAddress());
        dto.setBirthday(entity.getBirthday());
        dto.setRole(entity.getRole());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public static ProfileDetailDTO toShortDetail(ProfileEntity entity) {
        if (entity == null)
            return null;
        ProfileDetailDTO dto = new ProfileDetailDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setContact(entity.getContact());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
