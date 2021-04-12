package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.validation.Constant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@JacksonXmlRootElement(localName = "expe")
public class ExperienceDTO {

    @JacksonXmlProperty(localName = "datedeb")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateStart;

    @JacksonXmlProperty(localName = "datefin")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateEnd;

    @JacksonXmlProperty(localName = "titre")
    @NotBlank
    @Size(max = Constant.STRING_COMMENT_MAX)
    private String title;

    public ExperienceDTO() {

    }

    public ExperienceDTO(LocalDate dateStart, LocalDate dateEnd, String title) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.title = title;
    }

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
        return "ExperienceDTO{" +
                "datedeb=" + dateStart +
                ", datefin=" + dateEnd +
                ", titre='" + title + '\'' +
                '}';
    }
}
