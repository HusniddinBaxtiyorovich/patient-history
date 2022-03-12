package com.example.historydiseases.core.entity.profileEntity;


import com.example.historydiseases.core.entity.profileEntity.util.AgeType;
import com.example.historydiseases.feature_location.entity.Countries;
import com.example.historydiseases.feature_location.entity.Districts;
import com.example.historydiseases.feature_location.entity.Regions;
import com.example.historydiseases.core.entity.profileEntity.util.Gender;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileRole;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profile")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "patronymic")
    String patronymic;

    @Column(name = "address")
    String address;

    @Column(name = "birthday")
    Date birthday;


    @Column(name = "email", unique = true, nullable = false)  // = login
    @Email
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "contact")
    String contact;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    ProfileStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    ProfileRole role;

    @Column(name = "created_date")
    LocalDateTime createdDate;

    @Column(name = "writted_dates")
    LocalDateTime writtedDates;

    @NotNull
    @Column(name = "user_id")
    Long userId;

    @Column(name = "passport_serial")
    String passportSerial;

    @Column(name = "passport_number")
    String passportNumber;

    @Column(name = "pinfl")
    String pinfl;

    @Column(name = "phone_home")
    String mobilePhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    Gender gender;

    @Column(name = "resident")
    Boolean resident;

    @Enumerated(EnumType.STRING)
    @Column(name = "AgeType")
    AgeType ageType;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Countries country;

    @ManyToOne
    @JoinColumn(name = "region_id")
    Regions region;

    @ManyToOne
    @JoinColumn(name = "district_id")
    Districts district;

    @Column(name = "verified_at")
    LocalDateTime verified;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    LocalDateTime created;

    @LastModifiedDate
    @Column(name = "modified_at")
    LocalDateTime modified;



}
