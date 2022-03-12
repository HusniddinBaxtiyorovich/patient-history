package com.example.historydiseases.feature_criteria.entity;

import com.example.historydiseases.feature_criteria.HospitalType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hopsital") // Shifoxona
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeOfTreatment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String NameHospital;



    @Column(name = "hospitalType")
    @Enumerated(EnumType.STRING)
    HospitalType hospitalType;

    @Column(name = "location")
    String addresHospital;

    @OneToMany
    @JoinColumn(name = "type_Of_Disease_id")
    List<TypeOfDisease> typeOfDiseases;

    @ManyToOne
    @JoinColumn(name = "user_History_id")
    private UserHistory userHistory;



}