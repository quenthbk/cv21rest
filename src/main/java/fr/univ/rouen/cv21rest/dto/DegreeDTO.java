package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.DegreeLevel;
import fr.univ.rouen.cv21rest.validation.Constant;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@JacksonXmlRootElement(localName = "diplôme")
public class DegreeDTO implements Serializable {

    @JacksonXmlProperty(isAttribute = true, localName = "niveau")
    @NotNull
    private DegreeLevel level;

    @JacksonXmlProperty(localName = "date")
    @NotNull
    private LocalDate date;

    @JacksonXmlProperty(localName = "titre")
    @NotNull
    @Size(max = Constant.STRING_NAME_MAX)
    private String title;

    @JacksonXmlProperty(localName = "etab")
    @NotNull
    @Size(max = Constant.STRING_NAME_MAX)
    private String institution;

    public DegreeDTO() {

    }

    public DegreeDTO(DegreeLevel level, LocalDate date, String title, String institution) {
        this.level = level;
        this.date = date;
        this.title = title;
        this.institution = institution;
    }

    public DegreeLevel getLevel() {
        return level;
    }

    public void setLevel(DegreeLevel level) {
        this.level = level;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "DegreeDTO{" +
                "niveau=" + level +
                ", date=" + date +
                ", titre='" + title + '\'' +
                ", etab='" + institution + '\'' +
                '}';
    }
}
