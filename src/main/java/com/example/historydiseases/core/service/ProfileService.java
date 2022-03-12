package com.example.historydiseases.core.service;

import com.example.historydiseases.converter.ProfileConverter;
import com.example.historydiseases.core.dto.profile.ProfileCreateDTO;
import com.example.historydiseases.core.dto.profile.ProfileDetailDTO;
import com.example.historydiseases.core.dto.profile.ProfileFilterDTO;
import com.example.historydiseases.core.dto.profile.ProfileUpdateDTO;
import com.example.historydiseases.core.entity.profileEntity.ProfileEntity;
import com.example.historydiseases.core.exp.ItemNotFoundException;
import com.example.historydiseases.core.exp.ServerBadRequestException;
import com.example.historydiseases.core.repository.profilerepository.ProfileImageRepository;
import com.example.historydiseases.core.repository.profilerepository.ProfileRequestRepository;
import com.example.historydiseases.core.repository.profilerepository.ProfileRepository;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileRole;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileStatus;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileImageRepository profileImageRepository;
    private final ProfileRequestRepository profileRequestRepository;

    public ProfileDetailDTO getDetail(Long profileId) {

        ProfileEntity entity = get(profileId);

        ProfileDetailDTO dto = new ProfileDetailDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
//        dto.setEmail(entity.getEmail());
        dto.setContact(entity.getContact());
        dto.setGender(entity.getGender());
        dto.setCountry(entity.getCountry());
        dto.setDistrict(entity.getDistrict());
        dto.setRegion(entity.getRegion());
        dto.setPassportSerial(entity.getPassportSerial()); // agar password yoshiga yetgan bo`lsa
        dto.setPassportNumber(entity.getPassportNumber()); // agar password yoshiga yetgan bo`lsa
        dto.setPinfl(entity.getPinfl());                   // agar password yoshiga yetgan bo`lsa
        dto.setAgeType(entity.getAgeType());
        return dto;
    }

    public Boolean profileUpdateDetail(Long id, ProfileUpdateDTO dto) { // profile update own detail
        ProfileEntity entity = get(id);


        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setContact(dto.getContact());
        this.profileRepository.save(entity);
        return true;
    }

    public void profileUpdateEmail(Long id, String newEmail) {
        // TODO
    }

    // admin  , user
    public ProfileCreateDTO create(ProfileCreateDTO dto) {


        Optional<ProfileEntity> optional = Optional.of(profileRepository.getById(dto.getId()));
        if (optional.isPresent()) {
            throw new ServerBadRequestException("user already exists.");
        }
//        Optional<Profile> optional = profileRepository.getByEmail(dto.getEmail());
        if (optional.isPresent()) {
            throw new ServerBadRequestException("Email already exists.");
        }

        if (dto.getRole().equals(ProfileRole.ROLE_USER)) {
            throw new ServerBadRequestException("Sizda foydalanuvchi qo'shish huquqi mavjud emas");
        }
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
//        entity.setEmail(dto.getEmail());
        entity.setContact(dto.getContact());
        entity.setRole(dto.getRole());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setPassword(DigestUtils.md5Hex(dto.getPassword()));
        this.profileRepository.save(entity);

        dto.setId(entity.getId());
        return dto;
    }

    public Boolean update(Long id, ProfileCreateDTO dto) {
        ProfileEntity entity = get(id);
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
//        entity.setEmail(dto.getEmail());
        entity.setContact(dto.getContact());
        entity.setRole(dto.getRole());
        this.profileRepository.save(entity);
        return true;
    }

    public ProfileDetailDTO getById(Long id) {
        ProfileEntity profileEntity = get(id);
        return ProfileConverter.toDTO(profileEntity);
    }

    public Boolean changeStatus(Long id, ProfileStatus status) {
        this.profileRepository.updateStatus(status, id);
        return true;
    }

    public Page<ProfileDetailDTO> getListForPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<ProfileEntity> paging = this.profileRepository.findAll(pageable);

        Long totalElements = paging.getTotalElements();
        Integer totalPages = paging.getTotalPages();
        List<ProfileEntity> content = paging.getContent();

        Page<ProfileDetailDTO> resultPage = paging.map(ProfileConverter::toDTO);
        return resultPage;
    }

    public Page<ProfileDetailDTO> filter(ProfileFilterDTO filterDTO) {
        String sortBy = filterDTO.getSortBy();
        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "createdDate";
        }
        Pageable pageable = PageRequest.of(filterDTO.getPage(), filterDTO.getSize(), filterDTO.getDirection(), sortBy);

        List<Predicate> predicateList = new ArrayList<>();
        Specification<ProfileEntity> specification = (root, criteriaQuery, criteriaBuilder) -> {
            if (filterDTO.getName() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("name"), filterDTO.getName()));
            }
            if (filterDTO.getSurname() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("surname"), filterDTO.getSurname()));
            }
            if (filterDTO.getEmail() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("email"), filterDTO.getEmail()));
            }
            if (filterDTO.getContact() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("contact"), filterDTO.getContact()));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };


//        Page<Profile> paging =profileRepository.findAll(specification, pageable);

        Page<ProfileEntity> paging = profileRepository.findAll(pageable);
        List<ProfileDetailDTO> detailDTOList = new LinkedList<>();

        paging.forEach(profileEntity -> {
            detailDTOList.add(ProfileConverter.toDTO(profileEntity));
        });
        return paging.map(ProfileConverter::toDTO);
//        return new PageImpl<>(detailDTOList, pageable, paging.getTotalElements());
    }

    public ProfileEntity get(Long id) {
        Optional<ProfileEntity> optional = this.profileRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ItemNotFoundException("Profile Not Found");
        }
        return optional.get();
    }


}