package fr.univ.rouen.cv21rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public enum Objective {
    @JacksonXmlProperty(isAttribute = true, localName = "stage")
    INTERNSHIP("stage"),
    @JacksonXmlProperty(isAttribute = true, localName = "emploie")
    EMPLOYMENT("emploie");

    private String value;

    Objective(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Objective{" +
                "value='" + value + '\'' +
                '}';
    }
}
