package fr.univ.rouen.cv21rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gender {

    @JsonProperty("M")
    MAN("M"),
    @JsonProperty("Mme")
    WOMAN("Mme");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "value='" + value + '\'' +
                '}';
    }
}
