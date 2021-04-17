package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.LanguageCertification;
import fr.univ.rouen.cv21rest.model.LanguageLevel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;


public class VariousDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private final OtherDTO otherValid = new OtherDTO();

    private final LanguageDTO languageValid = new LanguageDTO();

    VariousDTOTest() {
        otherValid.setComment("string");
        otherValid.setTitle("string");
        languageValid.setName("string");
        languageValid.setLevel(LanguageLevel.A1);
        languageValid.setGrade(200);
        languageValid.setCertification(LanguageCertification.CLES);
    }


    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        VariousDTO value = new VariousDTO();
        // 5 languages
        value.setLanguages(Arrays.asList(languageValid,
                languageValid,
                languageValid,
                languageValid,
                languageValid));
        // 3 others
        value.setOthers((Arrays.asList(otherValid,
                otherValid,
                otherValid)));

        // WHEN
        Set<ConstraintViolation<VariousDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeValid_whenOtherIsEmpty() {
        // GIVEN
        VariousDTO value = new VariousDTO();
        value.setLanguages(Collections.singletonList(languageValid));

        // WHEN
        Set<ConstraintViolation<VariousDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenLanguageIsEmpty() {
        // GIVEN
        VariousDTO value = new VariousDTO();

        // WHEN
        Set<ConstraintViolation<VariousDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenLanguagesExceed5() {
        // GIVEN
        VariousDTO value = new VariousDTO();

        value.setLanguages(Arrays.asList(
                languageValid,
                languageValid,
                languageValid,
                languageValid,
                languageValid,
                languageValid));

        value.setOthers(Collections.singletonList(otherValid));

        // WHEN
        Set<ConstraintViolation<VariousDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenOthersExceed3() {
        // GIVEN
        VariousDTO value = new VariousDTO();

        value.setLanguages(Arrays.asList(languageValid,
                languageValid,
                languageValid,
                languageValid,
                languageValid));
        value.setOthers((Arrays.asList(otherValid,
                otherValid,
                otherValid,
                otherValid)));

        // WHEN
        Set<ConstraintViolation<VariousDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenOneOfOthersIsInvalid() {
        // GIVEN
        VariousDTO value = new VariousDTO();
        OtherDTO invalidOther = new OtherDTO();

        value.setLanguages(Arrays.asList(languageValid,
                languageValid,
                languageValid,
                languageValid,
                languageValid));
        value.setOthers((Arrays.asList(otherValid,
                otherValid,
                invalidOther)));

        // WHEN
        Set<ConstraintViolation<VariousDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }

    @Test
    public void shouldBeInvalid_whenOneOfLanguagesIsInvalid() {
        // GIVEN
        VariousDTO value = new VariousDTO();
        LanguageDTO invalidLanguage = new LanguageDTO();

        value.setLanguages(Arrays.asList(languageValid,
                languageValid,
                languageValid,
                languageValid,
                invalidLanguage));
        value.setOthers((Arrays.asList(otherValid,
                otherValid)));

        // WHEN
        Set<ConstraintViolation<VariousDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }
}
