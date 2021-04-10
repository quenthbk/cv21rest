package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.Gender;
import fr.univ.rouen.cv21rest.validation.Validator;

import javax.validation.constraints.*;

@JacksonXmlRootElement(localName = "identite")
public class IdentityDTO {
    @JacksonXmlProperty
    @NotNull
    private Gender genre;

    @JacksonXmlProperty
    @NotBlank
    @Size(max = Validator.STRING_NAME_MAX)
    private String nom;

    @JacksonXmlProperty
    @NotBlank
    @Size(max = Validator.STRING_NAME_MAX)
    private String prenom;

    @JacksonXmlProperty
    @Pattern(regexp = Validator.PHONE_NUMBER_REGEX)
    private String tel;

    @JacksonXmlProperty
    @Email
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

    @Override
    public String toString() {
        return "IdentityDTO{" +
                "genre=" + genre +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", mel='" + mel + '\'' +
                '}';
    }
}
