package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import fr.univ.rouen.cv21rest.model.Certification;
import fr.univ.rouen.cv21rest.model.LanguageLevel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lv")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class LanguageDTO implements VariousDTO {
    @XmlAttribute
    private String lang;

    @XmlAttribute
    private Certification cert;

    @XmlAttribute
    private LanguageLevel nivs;

    @XmlAttribute
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
}
