package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.Certification;
import fr.univ.rouen.cv21rest.model.DegreeLevel;
import fr.univ.rouen.cv21rest.model.LanguageLevel;
import fr.univ.rouen.cv21rest.validation.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@SpringBootTest
public class CompetencesDTOTest {

    @Autowired
    private Validator validator;

    private final DegreeDTO degreeValid = new DegreeDTO();

    private final CertificationDTO certificationValid = new CertificationDTO();

    CompetencesDTOTest() {
        degreeValid.setDate(LocalDate.now());
        degreeValid.setTitre("s".repeat(Constant.STRING_NAME_MAX));
        degreeValid.setEtab("s".repeat(Constant.STRING_NAME_MAX));
        degreeValid.setNiveau(DegreeLevel.I);
        certificationValid.setDatedeb(LocalDate.now());
        certificationValid.setDatefin(LocalDate.now());
        certificationValid.setTitre("s".repeat(Constant.STRING_COMMENT_MAX));
    }


    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        CompetencesDTO value = new CompetencesDTO();
        // 5 languages
        value.setDegrees(Arrays.asList(degreeValid,
                degreeValid,
                degreeValid,
                degreeValid,
                degreeValid));
        // 3 others
        value.setCertifications((Arrays.asList(certificationValid,
                certificationValid,
                certificationValid)));

        // WHEN
        Set<ConstraintViolation<CompetencesDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeValid_whenCertificationNotSet() {
        // GIVEN
        CompetencesDTO value = new CompetencesDTO();
        // 5 languages
        value.setDegrees(Arrays.asList(degreeValid,
                degreeValid,
                degreeValid,
                degreeValid,
                degreeValid));

        // WHEN
        Set<ConstraintViolation<CompetencesDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeValid_whenDegreeIsEmpty() {
        // GIVEN
        CompetencesDTO value = new CompetencesDTO();
        // 5 languages
        value.setDegrees(new ArrayList<>());

        // WHEN
        Set<ConstraintViolation<CompetencesDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeValid_whenDegreeExceed5() {
        // GIVEN
        CompetencesDTO value = new CompetencesDTO();
        // 5 languages
        value.setDegrees(Arrays.asList(degreeValid,
                degreeValid,
                degreeValid,
                degreeValid,
                degreeValid,
                degreeValid));

        // WHEN
        Set<ConstraintViolation<CompetencesDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }
}
