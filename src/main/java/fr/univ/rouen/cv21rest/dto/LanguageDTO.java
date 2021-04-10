package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.Certification;
import fr.univ.rouen.cv21rest.model.LanguageLevel;
import fr.univ.rouen.cv21rest.validation.Constant;

import javax.validation.constraints.*;

@JacksonXmlRootElement(localName = "lv")
public class LanguageDTO {
    @JacksonXmlProperty(isAttribute = true)
    @NotBlank
    @Size(max = Constant.STRING_NAME_MAX)
    private String lang;

    @JacksonXmlProperty(isAttribute = true)
    @NotNull
    private Certification cert;

    @JacksonXmlProperty(isAttribute = true)
    @NotNull
    private LanguageLevel nivs;

    @JacksonXmlProperty(isAttribute = true)
    @Min(10)
    @Max(990)
    private Integer nivi;

    public LanguageDTO() {

    }

    public LanguageDTO(String lang, Certification cert, LanguageLevel nivs, Integer nivi) {
        this.lang = lang;
        this.cert = cert;
        this.nivs = nivs;
        this.nivi = nivi;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Certification getCert() {
        return cert;
    }

    public void setCert(Certification cert) {
        this.cert = cert;
    }

    public LanguageLevel getNivs() {
        return nivs;
    }

    public void setNivs(LanguageLevel nivs) {
        this.nivs = nivs;
    }

    public Integer getNivi() {
        return nivi;
    }

    public void setNivi(Integer nivi) {
        this.nivi = nivi;
    }

    @Override
    public String toString() {
        return "LanguageDTO{" +
                "lang='" + lang + '\'' +
                ", cert=" + cert +
                ", nivs=" + nivs +
                ", nivi=" + nivi +
                '}';
    }
}
