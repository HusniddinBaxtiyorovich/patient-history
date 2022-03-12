package com.example.historydiseases.core.dto.profile;

import com.example.historydiseases.core.entity.AgeType;
import com.example.historydiseases.feature_location.entity.Countries;
import com.example.historydiseases.feature_location.entity.Districts;
import com.example.historydiseases.feature_location.entity.Regions;
import com.example.historydiseases.feature_profile.Gender;
import com.example.historydiseases.feature_profile.ProfileRole;
import com.example.historydiseases.feature_profile.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileDetailDTO {

    Long id;

    String name;

    String surname;

    String patronymic;

    String address;

    Date birthday;

    String email;

    String password;

    String contact;

    ProfileStatus status;

    ProfileRole role;

    LocalDateTime createdDate;

    LocalDateTime writtenDates;

    Long userId;

    String passportSerial;

    String passportNumber;

    String pinfl;

    String mobilePhone;

    Gender gender;

    Boolean resident; //doimiy yashaydi

    Countries country;

    Regions region;

    Districts district;

    LocalDateTime verified;

    LocalDateTime created;

    LocalDateTime modified;

    AgeType ageType;

    String token;

}