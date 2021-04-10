package fr.univ.rouen.cv21rest.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;

@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, include = JsonTypeInfo.As.PROPERTY, property = "name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OtherDTO.class, name = "autre"),
        @JsonSubTypes.Type(value = LanguageDTO.class, name = "lv")
})
public interface VariousDTO {

}
