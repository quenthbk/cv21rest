package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.DegreeLevel;
import fr.univ.rouen.cv21rest.validation.Constant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@JacksonXmlRootElement(localName = "diplôme")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DegreeDTO implements Serializable {

    @ApiModelProperty(notes = "Le niveau du diplôme", example = "IV")
    @JacksonXmlProperty(isAttribute = true, localName = "niveau")
    @NotNull
    private DegreeLevel level;

    @ApiModelProperty(notes = "La date d'obtention du diplôme", example = "1995-05-15")
    @JacksonXmlProperty(localName = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate date;

    @ApiModelProperty(notes = "Le nom du diplôme", example = "Baccalauréat")
    @JacksonXmlProperty(localName = "titre")
    @NotNull
    @Size(max = Constant.STRING_NAME_MAX)
    private String title;

    @ApiModelProperty(notes = "L'établissement de formation", example = "Jean Dupres Bontilly")
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
