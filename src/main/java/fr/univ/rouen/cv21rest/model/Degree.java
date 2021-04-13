package fr.univ.rouen.cv21rest.model;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class Degree implements Comparable<Degree> {
    private DegreeLevel level;

    private LocalDate date;

    private String title;

    private String institution;

    public DegreeLevel getLevel() {
        return level;
    }

    public void setLevel(DegreeLevel level) {
        this.level = level;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "level=" + level +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", institution='" + institution + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NotNull Degree degree) {
        return level.compareTo(degree.level);
    }
}
