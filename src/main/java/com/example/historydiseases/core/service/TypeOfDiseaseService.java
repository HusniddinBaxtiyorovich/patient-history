package com.example.historydiseases.core.service;

import com.example.historydiseases.converter.TypeOfDiseaseConverter;
import com.example.historydiseases.core.dto.TypeOfDisease.TypeOfDiseaseCreateDto;
import com.example.historydiseases.core.dto.TypeOfDisease.TypeOfDiseaseUpdateDetailDto;
import com.example.historydiseases.core.entity.profileEntity.ProfileEntity;
import com.example.historydiseases.core.exp.ItemNotFoundException;
import com.example.historydiseases.core.exp.ServerBadRequestException;
import com.example.historydiseases.core.dto.TypeOfDisease.TypeOfDiseaseDetailDto;
import com.example.historydiseases.core.dto.TypeOfDisease.TypeOfDiseaseFilterDto;
import com.example.historydiseases.core.dto.TypeOfDiseaseDto;
import com.example.historydiseases.core.entity.typeOfDiseaseEntity.TypeOfDisease;
import com.example.historydiseases.core.repository.typeOfDiseaseRepository.TypeOfDiseaseRepository;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileRole;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TypeOfDiseaseService {


    // Todo  -->> buni faqat doktorlar kirita oladi kasalliklar turini ->> dorilar turini


    private final TypeOfDiseaseRepository typeOfDiseaseRepository;


    public TypeOfDiseaseDto detailTyeDisease(Long id) {

        TypeOfDisease disease = get(id);

        TypeOfDiseaseDto diseaseDto = new TypeOfDiseaseDto();

        disease.setNameDiseas(disease.getNameDiseas());
        disease.setCategoryDiseas(disease.getCategoryDiseas());
        return diseaseDto;
    }


    public TypeOfDiseaseCreateDto createTypeDisease(TypeOfDiseaseCreateDto dto) {

        Optional<TypeOfDisease> optional = Optional.of(typeOfDiseaseRepository.getById(dto.getId()));
        if (optional.isPresent()) {
            throw new ServerBadRequestException("TypeOfDisease already exists.");
        }

        if (dto.getRole().equals(ProfileRole.ROLE_USER)) {
            throw new ServerBadRequestException("Sizda dori qo'shish huquqi mavjud emas");
        }

        TypeOfDisease disease = new TypeOfDisease();

        disease.setNameDiseas(dto.getNameDiseas());
        disease.setCategoryDiseas(dto.getCategoryDiseas());
        disease.setRole(dto.getRole());
        typeOfDiseaseRepository.save(disease);

        dto.setId(disease.getId());
        return dto;

    }

    public boolean update(Long id, TypeOfDiseaseUpdateDetailDto dto) {

        TypeOfDisease optional = get(id);

        optional.setNameDiseas(dto.getNameDiseas());
        optional.setCategoryDiseas(dto.getCategoryDiseas());
        optional.setRole(dto.getRole());
        typeOfDiseaseRepository.save(optional);
        return true;
    }


    public Page<TypeOfDiseaseDetailDto> getListForPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<TypeOfDisease> paging = this.typeOfDiseaseRepository.findAll(pageable);

        Long totalElements = paging.getTotalElements();
        Integer totalPages = paging.getTotalPages();
        List<TypeOfDisease> content = paging.getContent();

        Page<TypeOfDiseaseDetailDto> resultPages = paging.map(TypeOfDiseaseConverter::toDtoD);
        return resultPages;
    }

    public TypeOfDiseaseDetailDto getById(Long id){
        TypeOfDisease disease = get(id);
        return TypeOfDiseaseConverter.toDtoD(disease);
    }

    public Page<TypeOfDiseaseDetailDto> filter(TypeOfDiseaseFilterDto filterDto) {
        String sortBy = filterDto.getSortBy();
        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "createdDate";
        }
        Pageable pageable = PageRequest.of(filterDto.getPage(), filterDto.getSize(), filterDto.getDirection(), sortBy);

        List<Predicate> predicateList = new ArrayList<>();
        Specification<ProfileEntity> specification = (root, criteriaQuery, criteriaBuilder) -> {
            if (filterDto.getNameDiseas() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("name"), filterDto.getNameDiseas()));
            }
            if (filterDto.getCategoryDiseas() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("surname"), filterDto.getCategoryDiseas()));
            }
            if (filterDto.getTypeOfTreatment() != null) {
                predicateList.add(criteriaBuilder.equal(root.get("email"), filterDto.getTypeOfTreatment()));
            }

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
        Page<TypeOfDisease> paging = typeOfDiseaseRepository.findAll(pageable);
        List<TypeOfDiseaseDetailDto> detailDTOLists = new LinkedList<>();

        paging.forEach(typeOfDisease -> {
            detailDTOLists.add(TypeOfDiseaseConverter.toDtoD(typeOfDisease));
        });
//        return paging.map(TypeOfDiseaseConverter::toDto);
        return new PageImpl<>(detailDTOLists, pageable, paging.getTotalElements());
    }
    public TypeOfDisease get(Long id) {

        Optional<TypeOfDisease> optional = typeOfDiseaseRepository.findById(id);
        if (optional.isPresent()) {
            throw new ItemNotFoundException("TypeOfDisease Not Found");
        }
        return optional.get();
    }

}
