package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.Gender;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "identite")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class IdentityDTO {
    @XmlElement
    private Gender genre;

    @XmlElement
    private String nom;

    @XmlElement
    private String prenom;

    @XmlElement
    private String tel;

    @XmlElement
    private String mel;

    public Gender getGenre() {
        return genre;
    }

    public void setGenre(Gender genre) {
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMel() {
        return mel;
    }

    public void setMel(String mel) {
        this.mel = mel;
    }
}
