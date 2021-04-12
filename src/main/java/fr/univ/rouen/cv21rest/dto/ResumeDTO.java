package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "resume")
public class ResumeDTO {

    @JacksonXmlProperty(localName = "cv21")
    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<CVDTO> cvs;

    public ResumeDTO(List<CVDTO> cvs) {
        this.cvs = cvs;
    }

    public List<CVDTO> getCvs() {
        return cvs;
    }

    @Override
    public String toString() {
        return "ResumeDTO{" +
                "cvs=" + cvs +
                '}';
    }
}
