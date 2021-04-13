package fr.univ.rouen.cv21rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ObjectiveRequest {

    @JsonProperty("stage")
    INTERNSHIP("stage"),

    @JsonProperty("emploi")
    EMPLOYMENT("emploi");

    private final String value;

    ObjectiveRequest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
