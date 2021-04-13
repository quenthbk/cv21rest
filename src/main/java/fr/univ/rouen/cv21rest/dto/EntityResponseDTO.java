package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.CVStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;


@JacksonXmlRootElement(localName = "response")
public class EntityResponseDTO implements Serializable {

    @ApiModelProperty(notes = "L'identifiant du CV")
    @JacksonXmlProperty
    private String id;

    @ApiModelProperty(notes = "Le statut de la requête envoyée : \n" +
            "INSERT lors d'une insertion\n" +
            "UPDATE lors d'une mise à jour\n" +
            "DELETE lors d'un effacement")
    @JacksonXmlProperty
    private CVStatus status;

    public EntityResponseDTO(String id, CVStatus status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CVStatus getStatus() {
        return status;
    }

    public void setStatus(CVStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EntityResponseDTO{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
