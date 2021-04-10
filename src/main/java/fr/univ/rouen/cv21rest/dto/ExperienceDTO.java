package fr.univ.rouen.cv21rest.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "expe")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ExperienceDTO {

    @XmlElement
    private LocalDate datedeb;

    @XmlElement
    private LocalDate datefin;

    @XmlElement
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
}
