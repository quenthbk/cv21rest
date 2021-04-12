package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.model.Objective;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement(localName = "cv21")
public class CVDTO implements Serializable {
    private static final long SerialVersionUID = 1L;

    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @JacksonXmlProperty(localName = "identite")
    @Valid
    @NotNull
    private IdentityDTO identity;

    @JacksonXmlProperty
    private Objective objective;

    @JacksonXmlProperty(localName = "prof")
    @Valid
    @NotEmpty
    private List<@Valid ExperienceDTO> experiences;

    @JacksonXmlProperty(localName = "competences")
    @Valid
    @NotNull
    private CompetencesDTO competences;

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

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
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
