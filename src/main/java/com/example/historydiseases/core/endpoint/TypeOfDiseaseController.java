package com.example.historydiseases.core.endpoint;


import com.example.historydiseases.core.dto.TypeOfDisease.TypeOfDiseaseCreateDto;
import com.example.historydiseases.core.dto.TypeOfDisease.TypeOfDiseaseDetailDto;
import com.example.historydiseases.core.dto.TypeOfDisease.TypeOfDiseaseFilterDto;
import com.example.historydiseases.core.dto.TypeOfDisease.TypeOfDiseaseUpdateDetailDto;
import com.example.historydiseases.core.service.TypeOfDiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class TypeOfDiseaseController {

    private final TypeOfDiseaseService typeOfDiseaseService;


    @PostMapping("/adm")
    public ResponseEntity<?> create(@RequestBody TypeOfDiseaseCreateDto dto){
        typeOfDiseaseService.createTypeDisease(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/adm/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id, @RequestBody TypeOfDiseaseUpdateDetailDto dto){
        typeOfDiseaseService.update(id, dto);
        return ResponseEntity.ok().build();
    }


    @PutMapping("adm/id")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {

        TypeOfDiseaseDetailDto result = typeOfDiseaseService.getById(id);
        return ResponseEntity.ok().body(result);
    }

//  @PostMapping("/adm/filter")
//    public ResponseEntity<?> filter(@RequestBody TypeOfDiseaseFilterDto dto, HttpServletRequest request){

//        TypeOfDiseaseDetailDto result = typeOfDiseaseService.getc
//  }


//    ===================================================================

//
//    @PutMapping("/adm/{id}/status")
//    public ResponseEntity<?> changeStatus(@PathVariable("id") Long id, @RequestParam("status") ProfileStatus profileStatus, HttpServletRequest request) {
////        UserDetails userDetails = TokenUtil.getCurrentUser(request, ProfileRole.ADMIN);
//        profileService.changeStatus(id, profileStatus);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/adm/filter")
//    public ResponseEntity<?> filter(@RequestBody ProfileFilterDTO dto, HttpServletRequest request) {
////        UserDetails userDetails = TokenUtil.getCurrentUser(request, ProfileRole.ADMIN);
//        Page<ProfileDetailDTO> result = profileService.filter(dto);
//        return ResponseEntity.ok().body(result);
//    }

}
