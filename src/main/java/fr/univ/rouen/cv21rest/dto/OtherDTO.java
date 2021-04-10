package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.validation.Constant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JacksonXmlRootElement(localName = "autre")
public class OtherDTO {

    @JacksonXmlProperty(isAttribute = true)
    @NotBlank
    @Size(max = Constant.STRING_NAME_MAX)
    private String titre;

    @JacksonXmlProperty(isAttribute = true)
    @NotBlank
    @Size(max = Constant.STRING_COMMENT_MAX)
    private String comment;

    public OtherDTO() {

    }

    public OtherDTO(String titre, String comment) {
        this.titre = titre;
        this.comment = comment;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "OtherDTO{" +
                "titre='" + titre + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
