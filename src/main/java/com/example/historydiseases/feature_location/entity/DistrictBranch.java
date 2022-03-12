package com.example.historydiseases.feature_location.entity;
import com.example.historydiseases.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "district_branch")
@Data
public class DistrictBranch extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branch;

    @OneToOne
    @JoinColumn(name = "district_id", foreignKey = @ForeignKey(name = "fk_district_branch_district_id"))
    private Districts district;
}
