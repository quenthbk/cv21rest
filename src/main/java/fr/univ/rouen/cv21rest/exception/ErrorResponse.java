package fr.univ.rouen.cv21rest.exception;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.CVStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JacksonXmlRootElement(localName = "response")
public class ErrorResponse {

    @ApiModelProperty(example = "ERROR")
    @JacksonXmlProperty
    final private CVStatus status = CVStatus.ERROR;

    @ApiModelProperty(example = "message")
    @JacksonXmlProperty
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(String message) {
        return message;
    }
}
