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
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import com.example.historydiseases.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "regions")
public class Regions extends BaseEntity {
    @Id
    @Column(name = "region_id")
    private String regionId;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "lang")
    @CollectionTable(name = "region_names",
            joinColumns = @JoinColumn(name = "region_id"),
            foreignKey = @ForeignKey(name = "fk_region_region_names"))
    private Map<String, String> name = new HashMap<>();
}
