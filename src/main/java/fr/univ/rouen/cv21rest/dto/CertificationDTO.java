package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "certif")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CertificationDTO extends ExperienceDTO {

}
