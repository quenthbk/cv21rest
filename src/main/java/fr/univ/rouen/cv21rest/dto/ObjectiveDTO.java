package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import fr.univ.rouen.cv21rest.model.ObjectiveRequest;
import fr.univ.rouen.cv21rest.validation.Constant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JacksonXmlRootElement(localName = "objectif")
public class ObjectiveDTO {

    @ApiModelProperty(notes = "Le poste visé", example = "DevOps")
    @JacksonXmlText
    @Size(max = Constant.STRING_NAME_MAX)
    @NotBlank
    private String job;

    @ApiModelProperty(notes = "Le type de contrat", example = "emploi")
    @JacksonXmlProperty(isAttribute = true, localName = "statut")
    @NotNull
    private ObjectiveRequest request;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ObjectiveRequest getRequest() {
        return request;
    }

    public void setRequest(ObjectiveRequest request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "ObjectiveDTO{" +
                "job='" + job + '\'' +
                ", request='" + request + '\'' +
                '}';
    }
}
