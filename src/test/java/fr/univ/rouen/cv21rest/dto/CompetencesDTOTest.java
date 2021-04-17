package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.DegreeLevel;
import fr.univ.rouen.cv21rest.validation.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class CompetencesDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private final DegreeDTO degreeValid = new DegreeDTO();

    private final CertificationDTO certificationValid = new CertificationDTO();

    CompetencesDTOTest() {
        degreeValid.setDate(LocalDate.now());
        degreeValid.setTitle("s".repeat(Constant.STRING_NAME_MAX));
        degreeValid.setInstitution("s".repeat(Constant.STRING_NAME_MAX));
        degreeValid.setLevel(DegreeLevel.I);
        certificationValid.setDateStart(LocalDate.now());
        certificationValid.setDateEnd(LocalDate.now());
        certificationValid.setTitle("s".repeat(Constant.STRING_COMMENT_MAX));
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
