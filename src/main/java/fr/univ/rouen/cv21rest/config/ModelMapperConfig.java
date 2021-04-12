package fr.univ.rouen.cv21rest.config;

import fr.univ.rouen.cv21rest.dto.*;
import fr.univ.rouen.cv21rest.model.CV;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return configure(new ModelMapper());
    }

    private ModelMapper configure(ModelMapper modelMapper) {
        // CvDTO to CV
        modelMapper.typeMap(CVDTO.class, CV.class)
                // Various::languages -> languages
            .addMappings(mapper -> mapper.map(src ->
                    src.getVarious().getLanguages(), CV::setLanguages))
                // various::others -> others
            .addMappings(mapper -> mapper.map(src ->
                    src.getVarious().getOthers(), CV::setOthers))
                // Competences::degree -> degree
            .addMappings(mapper -> mapper.map(src ->
                    src.getCompetences().getDegrees(), CV::setDegrees))
                // Competences::certifications -> certifications
            .addMappings(mapper -> mapper.map(src ->
                    src.getCompetences().getCertifications(), CV::setCertifications));

        // CV to CvDTO
        modelMapper.typeMap(CV.class, CVDTO.class)
                // certifications -> Competences::certifications
            .addMappings(mapper -> mapper.map(
                    CV::getCertifications,
                    (dest, v) -> dest.getCompetences().setCertifications((List<CertificationDTO>) v)))
                // degrees -> Competences::degrees
            .addMappings(mapper -> mapper.map(
                    CV::getDegrees,
                    (dest, v) -> dest.getCompetences().setDegrees((List<DegreeDTO>) v)))
                // others -> Various::others
            .addMappings(mapper -> mapper.map(
                    CV::getOthers,
                    (dest, v) -> dest.getVarious().setOthers((List<OtherDTO>) v)))
                // languages -> Various::languages
            .addMappings(mapper -> mapper.map(
                    CV::getLanguages,
                    (dest, v) -> dest.getVarious().setLanguages((List<LanguageDTO>) v)));

        return modelMapper;
    }
}
