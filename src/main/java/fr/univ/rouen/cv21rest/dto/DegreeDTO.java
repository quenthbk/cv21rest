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

    @JacksonXmlProperty(isAttribute = true)
    @NotNull
    private DegreeLevel niveau;

    @JacksonXmlProperty
    @NotNull
    private LocalDate date;

    @JacksonXmlProperty
    @NotNull
    @Size(max = Constant.STRING_NAME_MAX)
    private String titre;

    @JacksonXmlProperty
    @NotNull
    @Size(max = Constant.STRING_NAME_MAX)
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

    @Override
    public String toString() {
        return "DegreeDTO{" +
                "niveau=" + niveau +
                ", date=" + date +
                ", titre='" + titre + '\'' +
                ", etab='" + etab + '\'' +
                '}';
    }
}
