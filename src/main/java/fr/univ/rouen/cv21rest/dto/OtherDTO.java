package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "autre")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class OtherDTO implements VariousDTO {

    @XmlAttribute
    private String titre;

    @XmlAttribute
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
}
