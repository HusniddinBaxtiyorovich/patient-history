package com.example.historydiseases.core.entity.typeOfHospital;

import com.example.historydiseases.core.entity.typeOfDiseaseEntity.TypeOfDisease;
import com.example.historydiseases.core.entity.userHistoryEntity.UserHistory;
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
public class Hospital {


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