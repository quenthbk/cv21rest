package fr.univ.rouen.cv21rest.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@JacksonXmlRootElement(localName = "divers")
public class VariousDTO {

    @ApiModelProperty(notes = "La liste dans langues associées au CV")
    @JacksonXmlProperty(localName = "lv")
    @JacksonXmlElementWrapper(useWrapping = false)
    @Size(min = 1, max = 5)
    @NotEmpty
    private List<@Valid LanguageDTO> languages;

    @ApiModelProperty(notes = "La liste des informations complémentaires associées au CV")
    @JacksonXmlProperty(localName = "autre")
    @JacksonXmlElementWrapper(useWrapping = false)
    @Size(max = 3)
    private List<@Valid OtherDTO> others;

    public List<LanguageDTO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageDTO> languages) {
        this.languages = languages;
    }

    public List<OtherDTO> getOthers() {
        return others;
    }

    public void setOthers(List<OtherDTO> others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "VariousDTO{" +
                "languages=" + languages +
                ", others=" + others +
                '}';
    }
}
