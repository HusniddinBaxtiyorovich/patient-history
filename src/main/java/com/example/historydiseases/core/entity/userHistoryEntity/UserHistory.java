package com.example.historydiseases.core.entity.userHistoryEntity;

import com.example.historydiseases.core.entity.BaseEntity;
import com.example.historydiseases.core.entity.profileEntity.ProfileEntity;
import com.example.historydiseases.core.entity.typeOfHospital.Hospital;
import com.example.historydiseases.core.entity.typeOfHospital.HospitalType;
import com.example.historydiseases.feature_criteria.Proses;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "UserHistory")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "address")
    @Enumerated(EnumType.STRING)
    HospitalType address;

    @Column(name = "proses")
    @Enumerated(EnumType.STRING)
    Proses proses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userHistory")
    List<Hospital> typeOfTreatment;


    @ManyToOne
    @JoinColumn(name = "profile_id")
    ProfileEntity profile;


}
