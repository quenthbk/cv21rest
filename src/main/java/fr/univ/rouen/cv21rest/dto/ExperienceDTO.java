package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.validation.Constant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@JacksonXmlRootElement(localName = "expe")
public class ExperienceDTO {

    @JacksonXmlProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate datedeb;

    @JacksonXmlProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate datefin;

    @JacksonXmlProperty
    @NotBlank
    @Size(max = Constant.STRING_COMMENT_MAX)
    private String titre;

    public ExperienceDTO() {

    }

    public ExperienceDTO(LocalDate datedeb, LocalDate datefin, String titre) {
        this.datedeb = datedeb;
        this.datefin = datefin;
        this.titre = titre;
    }

    public LocalDate getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(LocalDate datedeb) {
        this.datedeb = datedeb;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "ExperienceDTO{" +
                "datedeb=" + datedeb +
                ", datefin=" + datefin +
                ", titre='" + titre + '\'' +
                '}';
    }
}
