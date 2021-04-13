package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement(localName = "cv21:cv21")
public class CVDTO implements Serializable {
    private static final long SerialVersionUID = 1L;

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:cv21")
    public final String XMLNS = "http://univ.fr/cv21";

    @ApiModelProperty(notes = "L'identifient unique du CV")
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @ApiModelProperty(notes = "L'identité de la personne associée au CV")
    @JacksonXmlProperty(localName = "identite")
    @Valid
    @NotNull
    private IdentityDTO identity;

    @ApiModelProperty(notes = "L'objectif associé au CV")
    @JacksonXmlProperty(localName = "objectif")
    @Valid
    @NotNull
    private ObjectiveDTO objective;

    @ApiModelProperty(notes = "L'expérience professionnelle de la personne")
    @JacksonXmlElementWrapper(localName = "prof")
    @JacksonXmlProperty(localName = "expe")
    @Valid
    @NotEmpty
    private List<@Valid ExperienceDTO> experiences;

    @ApiModelProperty(notes = "Les compétences mises en avant")
    @JacksonXmlProperty(localName = "competences")
    @Valid
    @NotNull
    private CompetencesDTO competences;

    @ApiModelProperty(notes = "Informations complémentaires")
    @JacksonXmlProperty(localName = "divers")
    @Valid
    @NotNull
    private VariousDTO various;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IdentityDTO getIdentity() {
        return identity;
    }

    public void setIdentity(IdentityDTO identity) {
        this.identity = identity;
    }

    public List<ExperienceDTO> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<ExperienceDTO> experiences) {
        this.experiences = experiences;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public VariousDTO getVarious() {
        return various;
    }

    public void setVarious(VariousDTO various) {
        this.various = various;
    }

    public ObjectiveDTO getObjective() {
        return objective;
    }

    public void setObjective(ObjectiveDTO objective) {
        this.objective = objective;
    }

    public CompetencesDTO getCompetences() {
        return competences;
    }

    public void setCompetences(CompetencesDTO competences) {
        this.competences = competences;
    }

    @Override
    public String toString() {
        return "CVDTO{" +
                "id=" + id +
                ", identite=" + identity +
                ", objectif=" + objective +
                ", prof=" + experiences +
                ", competences=" + competences +
                ", divers=" + various +
                '}';
    }
}
