package com.example.historydiseases.feature_criteria.entity;

import com.example.historydiseases.core.BaseEntity;
import com.example.historydiseases.core.entity.Profile;
import com.example.historydiseases.feature_criteria.HospitalType;
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
    List<TypeOfTreatment> typeOfTreatment;


    @ManyToOne
    @JoinColumn(name = "profile_id")
    Profile profile;


}
