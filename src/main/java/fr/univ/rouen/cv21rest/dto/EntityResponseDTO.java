package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.CVStatus;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;


@JacksonXmlRootElement(localName = "response")
public class EntityResponseDTO implements Serializable {
    @JacksonXmlProperty
    private long id;

    @JacksonXmlProperty
    private CVStatus status;

    public EntityResponseDTO(long id, CVStatus status) {
        this.id = id;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
