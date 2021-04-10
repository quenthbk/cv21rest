package fr.univ.rouen.cv21rest.exception;

import fr.univ.rouen.cv21rest.model.CVStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class ErrorResponse {

    @XmlElement
    final private CVStatus status = CVStatus.ERROR;

    @XmlElement
    private String message;

    public ErrorResponse(String message) {
        setMessage(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(String message) {
        return message;
    }
}
