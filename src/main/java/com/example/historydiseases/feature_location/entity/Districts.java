package com.example.historydiseases.feature_location.entity;


import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import com.example.historydiseases.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "districts")
public class Districts extends BaseEntity {
    @Id
    @Column(name = "district_id")
    private String districtId;

    @ManyToOne()
    @JoinColumn(name = "region_id")
    private Regions region;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "lang")
    @CollectionTable(name = "district_names",
            joinColumns = @JoinColumn(name = "district_id"), foreignKey = @ForeignKey(name = "fk_district_district_names"))
    private Map<String, String> name = new HashMap<>();
}
