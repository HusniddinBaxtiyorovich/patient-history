package com.example.historydiseases.feature_profile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MALE(1),
    FEMALE(2),
    UNKNOWN(3);

    private final Integer id;

    public static Gender fetchById(Integer id) {
        for (Gender value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
