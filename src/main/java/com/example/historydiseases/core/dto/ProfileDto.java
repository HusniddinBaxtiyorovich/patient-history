package com.example.historydiseases.core.dto;

import com.example.historydiseases.feature_location.entity.Countries;
import com.example.historydiseases.feature_location.entity.Districts;
import com.example.historydiseases.feature_location.entity.Regions;
import com.example.historydiseases.feature_profile.Gender;
import com.example.historydiseases.feature_profile.ProfileRole;
import com.example.historydiseases.feature_profile.ProfileStatus;
import lombok.Data;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ProfileDto {


    Long id;

    String name;

    String surname;

    private String patronymic;

    private String address;

    private Date birthday;

    @Email
    String email;

    String password;

    String contact;

    ProfileStatus status;

    ProfileRole role;

    LocalDateTime createdDate;

    LocalDateTime writtedDates;


    private Long userId;

    private String bankClientId;

    private String branch;

    private String taxRegistrationNumber;

    private String passportSerial;

    private String passportNumber;

    private String pinfl;

    private String homePhone;

    private String mobilePhone;

    private Gender gender;

    private Boolean resident;

    private Countries country;

    private Regions region;

    private Districts district;

    private LocalDateTime verified;

    private LocalDateTime created;

    private LocalDateTime modified;

}
