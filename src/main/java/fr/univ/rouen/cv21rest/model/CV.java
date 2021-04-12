package fr.univ.rouen.cv21rest.model;

import ch.qos.logback.core.encoder.EchoEncoder;

import java.util.List;

public class CV {
    private String id;

    private Identity identity;

    private Objective objective;

    private List<Degree> degrees;

    private List<Experience> certifications;

    private List<Experience> experiences;

    private List<Language> languages;

    private List<Other> others;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public List<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Other> getOthers() {
        return others;
    }

    public void setOthers(List<Other> others) {
        this.others = others;
    }

    public List<Experience> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Experience> certifications) {
        this.certifications = certifications;
    }

    @Override
    public String toString() {
        return "CV{" +
                "id=" + id +
                ", identity=" + identity +
                ", objective=" + objective +
                ", degrees=" + degrees +
                ", certifications=" + certifications +
                ", experiences=" + experiences +
                ", languages=" + languages +
                ", others=" + others +
                '}';
    }
}
