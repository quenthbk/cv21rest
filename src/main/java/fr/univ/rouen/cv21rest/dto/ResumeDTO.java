package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@JacksonXmlRootElement(localName = "resume")
public class ResumeDTO {

    @ApiModelProperty(notes = "Une liste de CV")
    @JacksonXmlProperty(localName = "cv21")
    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<CVResumedDTO> cvs;

    public ResumeDTO(List<CVResumedDTO> cvs) {
        this.cvs = cvs;
    }

    public List<CVResumedDTO> getCvs() {
        return cvs;
    }

    @Override
    public String toString() {
        return "ResumeDTO{" +
                "cvs=" + cvs +
                '}';
    }
}
