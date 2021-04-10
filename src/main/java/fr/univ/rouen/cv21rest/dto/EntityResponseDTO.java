package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.CVStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EntityResponseDTO {
    @XmlElement
    private long id;

    @XmlElement
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
}
