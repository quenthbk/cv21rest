package fr.univ.rouen.cv21rest.model;

import java.time.LocalDate;

public class Experience {
    private LocalDate dateStart;

    private LocalDate dateEnd;

    private String title;

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", title='" + title + '\'' +
                '}';
    }
}
