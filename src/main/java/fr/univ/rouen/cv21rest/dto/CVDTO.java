package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private long id;

    @JacksonXmlProperty
    @Valid
    @NotNull
    private IdentityDTO identite;

    @JacksonXmlProperty(isAttribute = true)
    private Objective objectif;

    @JacksonXmlProperty
    @Valid
    @NotEmpty
    private List<@Valid ExperienceDTO> prof;

    @JacksonXmlProperty
    @Valid
    @NotNull
    private CompetencesDTO competences;

    @JacksonXmlProperty
    @Valid
    @NotNull
    private VariousDTO divers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public IdentityDTO getIdentite() {
        return identite;
    }

    public void setIdentite(IdentityDTO identite) {
        this.identite = identite;
    }

    public List<ExperienceDTO> getProf() {
        return prof;
    }

    public void setProf(List<ExperienceDTO> prof) {
        this.prof = prof;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public VariousDTO getDivers() {
        return divers;
    }

    public void setDivers(VariousDTO divers) {
        this.divers = divers;
    }

    public Objective getObjectif() {
        return objectif;
    }

    public void setObjectif(Objective objectif) {
        this.objectif = objectif;
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
                ", identite=" + identite +
                ", objectif=" + objectif +
                ", prof=" + prof +
                ", competences=" + competences +
                ", divers=" + divers +
                '}';
    }
}
