package fr.univ.rouen.cv21rest.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public enum Gender {

    @JsonAlias("M")
    MAN("M"),
    @JsonAlias("Mme")
    WOMAN("Mme");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
