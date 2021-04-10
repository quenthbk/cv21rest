package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.DegreeLevel;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;

@XmlRootElement(name = "diplôme")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class DegreeDTO {

    @XmlAttribute
    private DegreeLevel niveau;

    @XmlElement
    private LocalDate date;

    @XmlElement
    private String titre;

    @XmlElement
    private String etab;

    public DegreeDTO() {

    }

    public DegreeDTO(DegreeLevel niveau, LocalDate date, String titre, String etab) {
        this.niveau = niveau;
        this.date = date;
        this.titre = titre;
        this.etab = etab;
    }

    public DegreeLevel getNiveau() {
        return niveau;
    }

    public void setNiveau(DegreeLevel niveau) {
        this.niveau = niveau;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEtab() {
        return etab;
    }

    public void setEtab(String etab) {
        this.etab = etab;
    }
}
