package com.example.historydiseases.feature_location.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
@Entity
@Table(name = "countries")
public class Countries {
    @Id
    @Column(name = "country_id")
    private String countryId;

    @Column(name = "alpha_code")
    private String codeAlpha;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "lang")
    @CollectionTable(name = "country_names",
            joinColumns = @JoinColumn(name = "country_id"),
            foreignKey = @ForeignKey(name = "fk_country_country_names"))
    private Map<String, String> name = new HashMap<>();
}
