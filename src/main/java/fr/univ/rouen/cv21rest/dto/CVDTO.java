package fr.univ.rouen.cv21rest.dto;

import org.springframework.cglib.transform.ClassVisitorTee;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "cv")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CVDTO implements Serializable {
    private static final long SerialVersionUID = 1L;

    private long id;

    @XmlElement
    private IdentityDTO identite;

    @XmlElement
    private List<ExperienceDTO> prof;

    @XmlElement
    private List<DegreeDTO> competences;

    @XmlElement
    private List<VariousDTO> divers;

    public CVDTO() {

    }

    public CVDTO(IdentityDTO identite, List<ExperienceDTO> prof, List<DegreeDTO> competences, List<VariousDTO> divers) {
        this.identite = identite;
        this.prof = prof;
        this.competences = competences;
        this.divers = divers;
    }

    public CVDTO(long id, IdentityDTO identite, List<ExperienceDTO> prof, List<DegreeDTO> competences,
                 List<VariousDTO> divers) {
        this(identite, prof, competences, divers);
        this.id = id;
    }

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

    public List<DegreeDTO> getCompetences() {
        return competences;
    }

    public void setCompetences(List<DegreeDTO> competences) {
        this.competences = competences;
    }

    public List<VariousDTO> getDivers() {
        return divers;
    }

    public void setDivers(List<VariousDTO> divers) {
        this.divers = divers;
    }
}
