package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.LanguageCertification;
import fr.univ.rouen.cv21rest.model.LanguageLevel;
import fr.univ.rouen.cv21rest.validation.Constant;

import javax.validation.constraints.*;

@JacksonXmlRootElement(localName = "lv")
public class LanguageDTO {
    @JacksonXmlProperty(isAttribute = true, localName = "lang")
    @NotBlank
    @Size(max = Constant.STRING_NAME_MAX)
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "cert")
    @NotNull
    private LanguageCertification certification;

    @JacksonXmlProperty(isAttribute = true, localName = "nivs")
    @NotNull
    private LanguageLevel level;

    @JacksonXmlProperty(isAttribute = true, localName = "nivi")
    @Min(10)
    @Max(990)
    private Integer grade;

    public LanguageDTO() {

    }

    public LanguageDTO(String name, LanguageCertification certification, LanguageLevel level, Integer grade) {
        this.name = name;
        this.certification = certification;
        this.level = level;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageCertification getCertification() {
        return certification;
    }

    public void setCertification(LanguageCertification certification) {
        this.certification = certification;
    }

    public LanguageLevel getLevel() {
        return level;
    }

    public void setLevel(LanguageLevel level) {
        this.level = level;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "LanguageDTO{" +
                "lang='" + name + '\'' +
                ", cert=" + certification +
                ", nivs=" + level +
                ", nivi=" + grade +
                '}';
    }
}
