package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.Gender;
import fr.univ.rouen.cv21rest.validation.Constant;

import javax.validation.constraints.*;

@JacksonXmlRootElement(localName = "identite")
public class IdentityDTO {
    @JacksonXmlProperty(localName = "genre")
    @NotNull
    private Gender gender;

    @JacksonXmlProperty(localName = "nom")
    @NotBlank
    @Size(max = Constant.STRING_NAME_MAX)
    private String lastname;

    @JacksonXmlProperty(localName = "prenom")
    @NotBlank
    @Size(max = Constant.STRING_NAME_MAX)
    private String firstname;

    @JacksonXmlProperty(localName = "tel")
    @Pattern(regexp = Constant.PHONE_NUMBER_REGEX)
    private String phoneNumber;

    @JacksonXmlProperty(localName = "mel")
    @Email
    private String email;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "IdentityDTO{" +
                "genre=" + gender +
                ", nom='" + lastname + '\'' +
                ", prenom='" + firstname + '\'' +
                ", tel='" + phoneNumber + '\'' +
                ", mel='" + email + '\'' +
                '}';
    }
}
