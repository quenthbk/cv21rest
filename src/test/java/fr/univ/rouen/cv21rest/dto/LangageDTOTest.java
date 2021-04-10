package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.Certification;
import fr.univ.rouen.cv21rest.model.LanguageLevel;
import fr.univ.rouen.cv21rest.validation.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class LangageDTOTest {

    @Autowired
    private Validator validator;

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCert(Certification.CLES);
        language.setLang("lang");
        language.setNivi(50);
        language.setNivs(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeValid_whenNiviIsNull() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCert(Certification.CLES);
        language.setLang("lang");
        language.setNivi(null);
        language.setNivs(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenNiviIsLessThan10() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCert(Certification.CLES);
        language.setLang("lang");
        language.setNivi(9);
        language.setNivs(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenNiviIsGreaterThan990() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCert(Certification.CLES);
        language.setLang("lang");
        language.setNivi(991);
        language.setNivs(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenCertIsNotSet() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setLang("lang");
        language.setNivi(990);
        language.setNivs(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenNivsIsNotSet() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setLang("lang");
        language.setCert(Certification.CLES);
        language.setNivi(990);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenLangIsNotSet() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCert(Certification.CLES);
        language.setNivi(990);
        language.setNivs(LanguageLevel.A1);

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenLangExceed32Char() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCert(Certification.CLES);
        language.setNivi(990);
        language.setNivs(LanguageLevel.A1);
        language.setLang("s".repeat(Constant.STRING_NAME_MAX + 1));

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenLangIsBlank() {
        // GIVEN
        LanguageDTO language = new LanguageDTO();
        language.setCert(Certification.CLES);
        language.setNivi(990);
        language.setNivs(LanguageLevel.A1);
        language.setLang("          ");

        // WHEN
        Set<ConstraintViolation<LanguageDTO>> violations =  validator.validate(language);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }
}
