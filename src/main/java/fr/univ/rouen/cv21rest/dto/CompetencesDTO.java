package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@JacksonXmlRootElement(localName = "competences")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CompetencesDTO {

    @ApiModelProperty(notes = "Liste des diplômes")
    @JacksonXmlProperty(localName = "diplôme")
    @JacksonXmlElementWrapper(useWrapping = false)
    @NotEmpty
    @Size(max = 5)
    private List<@Valid DegreeDTO> degrees;

    @ApiModelProperty(notes = "Liste des certifications")
    @JacksonXmlProperty(localName = "certif")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<@Valid CertificationDTO> certifications;

    public List<DegreeDTO> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<DegreeDTO> degrees) {
        this.degrees = degrees;
    }

    public List<CertificationDTO> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<CertificationDTO> certifications) {
        this.certifications = certifications;
    }
}
