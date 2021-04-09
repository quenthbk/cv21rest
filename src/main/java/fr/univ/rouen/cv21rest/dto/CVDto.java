package fr.univ.rouen.cv21rest.dto;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "cv")
@XmlAccessorType(XmlAccessType.NONE)
public class CVDto implements Serializable {
    private static final long SerialVersionUID = 1L;

    @XmlAttribute
    private Integer id;

    @XmlElement
    private String nom;

    @XmlElement
    private String prenom;

    @XmlElement
    private String date;

    @XmlElement
    private String mel;

    public CVDto(String nom, String prenom, String date, String mel) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.mel = mel;
    }

    public CVDto() {

    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate() {
        return date;
    }

    public String getMel() {
        return mel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMel(String mel) {
        this.mel = mel;
    }

    @Override
    public String toString() {
        return ("CV [" + nom + " " + prenom
            + ",Date=" + date + ", mel=" + mel + "]");
    }
}
