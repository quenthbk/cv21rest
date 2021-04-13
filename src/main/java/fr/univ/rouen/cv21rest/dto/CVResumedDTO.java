package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "cv21")
public class CVResumedDTO {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "prénom")
    private String firstname;

    @JacksonXmlProperty(localName = "nom")
    private String lastname;

    @JacksonXmlProperty(localName = "objectif")
    private ObjectiveDTO objective;

    @JacksonXmlProperty(localName = "diplôme")
    private DegreeDTO degree;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ObjectiveDTO getObjective() {
        return objective;
    }

    public void setObjective(ObjectiveDTO objective) {
        this.objective = objective;
    }

    public DegreeDTO getDegree() {
        return degree;
    }

    public void setDegree(DegreeDTO degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "CVResumedDTO{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", objective=" + objective +
                ", degree=" + degree +
                '}';
    }
}
