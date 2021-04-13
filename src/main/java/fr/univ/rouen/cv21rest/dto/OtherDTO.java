package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univ.rouen.cv21rest.validation.Constant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JacksonXmlRootElement(localName = "autre")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OtherDTO {

    @ApiModelProperty(notes = "Le titre de l'élément", example = "Permis")
    @JacksonXmlProperty(isAttribute = true, localName = "titre")
    @NotBlank
    @Size(max = Constant.STRING_NAME_MAX)
    private String title;

    @ApiModelProperty(notes = "Un commentaire", example = "B")
    @JacksonXmlProperty(isAttribute = true, localName = "comment")
    @NotBlank
    @Size(max = Constant.STRING_COMMENT_MAX)
    private String comment;

    public OtherDTO() {

    }

    public OtherDTO(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "OtherDTO{" +
                "titre='" + title + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
