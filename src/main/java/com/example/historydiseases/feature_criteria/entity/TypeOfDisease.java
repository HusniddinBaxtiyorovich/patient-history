package com.example.historydiseases.feature_criteria.entity;

import com.example.historydiseases.feature_profile.ProfileRole;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "types_disease") //Kasallik turi
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeOfDisease {

    @Id
    Long id;

    @Column
    String nameDiseas; // kasalliklar nomi

    @Column
    String categoryDiseas;

    @Column(name = "create_date")
    @CreatedDate
    LocalDateTime createdDate;

    @Column
    @Enumerated(EnumType.STRING)
    ProfileRole role;

    @OneToOne
    @JoinColumn(name = "typeOfTreatment_id")
    TypeOfTreatment typeOfTreatment;
}
