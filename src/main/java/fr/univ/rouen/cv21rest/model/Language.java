package fr.univ.rouen.cv21rest.model;

public class Language {

    private String name;

    private LanguageCertification certification;

    private LanguageLevel level;

    private Integer grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageCertification getCertification() {
        return certification;
    }

    public void setCertification(LanguageCertification certification) {
        this.certification = certification;
    }

    public LanguageLevel getLevel() {
        return level;
    }

    public void setLevel(LanguageLevel level) {
        this.level = level;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                ", certification=" + certification +
                ", level=" + level +
                ", grade=" + grade +
                '}';
    }
}
