package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.LanguageCertification;
import fr.univ.rouen.cv21rest.model.LanguageLevel;
import fr.univ.rouen.cv21rest.validation.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class LangageDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCertification(LanguageCertification.CLES);
        language.setName("lang");
        language.setGrade(50);
        language.setLevel(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeValid_whenNiviIsNull() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCertification(LanguageCertification.CLES);
        language.setName("lang");
        language.setGrade(null);
        language.setLevel(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenNiviIsLessThan10() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCertification(LanguageCertification.CLES);
        language.setName("lang");
        language.setGrade(9);
        language.setLevel(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenNiviIsGreaterThan990() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCertification(LanguageCertification.CLES);
        language.setName("lang");
        language.setGrade(991);
        language.setLevel(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenCertIsNotSet() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setName("lang");
        language.setGrade(990);
        language.setLevel(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenNivsIsNotSet() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setName("lang");
        language.setCertification(LanguageCertification.CLES);
        language.setGrade(990);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenLangIsNotSet() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCertification(LanguageCertification.CLES);
        language.setGrade(990);
        language.setLevel(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenLangExceed32Char() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCertification(LanguageCertification.CLES);
        language.setGrade(990);
        language.setLevel(LanguageLevel.A1);
        language.setName("s".repeat(Constant.STRING_NAME_MAX + 1));

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenLangIsBlank() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCertification(LanguageCertification.CLES);
        language.setGrade(990);
        language.setLevel(LanguageLevel.A1);
        language.setName("          ");

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }
}
