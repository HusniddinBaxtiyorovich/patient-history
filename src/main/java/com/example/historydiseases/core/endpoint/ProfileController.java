package com.example.historydiseases.core.endpoint;

import com.example.historydiseases.core.dto.profile.ProfileCreateDTO;
import com.example.historydiseases.core.dto.profile.ProfileDetailDTO;
import com.example.historydiseases.core.dto.profile.ProfileFilterDTO;
import com.example.historydiseases.core.dto.profile.ProfileUpdateDTO;
import com.example.historydiseases.core.security.SpringSecurityUtil;
import com.example.historydiseases.core.service.ProfileService;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileStatus;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final ProfileService profileService;

    /*
      create profile
      update profile
      delete profile
      getall profile
      get profile


     */


    /*
     ------------------------------------User----------------------------------------
     */
    @GetMapping("/detail")
    @ApiOperation(value = "Get Profile All Detail", notes = "get greeting", nickname = "getGreeting",
            authorizations = {@Authorization(value = "JWT Token")})
    public ResponseEntity<ProfileDetailDTO> getProfileDetail(HttpServletRequest request) {
        Long userId = SpringSecurityUtil.getUserId();
        ProfileDetailDTO dto = profileService.getDetail(userId);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/detail")
    public ResponseEntity<?> updateDetail(@Valid @RequestBody ProfileUpdateDTO dto) {
        Long userId = SpringSecurityUtil.getUserId();
        profileService.profileUpdateDetail(userId, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/email")
    public ResponseEntity<?> updateEmail(@RequestParam("email") String email) {
        Long userId = SpringSecurityUtil.getUserId();
        profileService.profileUpdateEmail(userId, email);
        return ResponseEntity.ok().build();
    }

    /*
     ------------------------------------Admin-----------------------------------------------
     */
    @PostMapping("/adm")
    public ResponseEntity<?> create(@RequestBody ProfileCreateDTO dto) {
        profileService.create(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/adm/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProfileCreateDTO dto) {
//        UserDetails userDetails = TokenUtil.getCurrentUser(request, ProfileRole.ADMIN);
        profileService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/adm/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
//        UserDetails userDetails = TokenUtil.getCurrentUser(request, ProfileRole.ADMIN);
        ProfileDetailDTO result = profileService.getById(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/adm/{id}/status")
    public ResponseEntity<?> changeStatus(@PathVariable("id") Long id, @RequestParam("status") ProfileStatus profileStatus, HttpServletRequest request) {
//        UserDetails userDetails = TokenUtil.getCurrentUser(request, ProfileRole.ADMIN);
        profileService.changeStatus(id, profileStatus);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/adm/filter")
    public ResponseEntity<?> filter(@RequestBody ProfileFilterDTO dto, HttpServletRequest request) {
//        UserDetails userDetails = TokenUtil.getCurrentUser(request, ProfileRole.ADMIN);
        Page<ProfileDetailDTO> result = profileService.filter(dto);
        return ResponseEntity.ok().body(result);
    }

}
