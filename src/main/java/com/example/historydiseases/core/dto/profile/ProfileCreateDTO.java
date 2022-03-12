package com.example.historydiseases.core.dto.profile;

import com.example.historydiseases.core.entity.profileEntity.util.AgeType;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ProfileCreateDTO {
    private Long id;
    @NotEmpty(message = "Please provide a name")
    private String name;
    @NotBlank(message = "Please provide a surname")
    private String surname;
//    @Email(message = "Voy email xatoku")
//    private String email;
    @NotEmpty(message = "Please provide a contact")
    private String contact;
    @NotBlank(message = "Please provide a  password")
    @Size(min = 5, max = 15, message = "15 dan ko'p bo'lsa esingdan chiqadiku.")
    private String password;
    @NotNull
    private ProfileRole role;

    private AgeType ageType;
}
