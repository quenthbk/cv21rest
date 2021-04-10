package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.validation.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

@SpringBootTest
public class ExperienceDTOTest {

    @Autowired
    private Validator validator;

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        ExperienceDTO value = new ExperienceDTO();
        value.setDatedeb(LocalDate.now());
        value.setDatefin(LocalDate.now());
        value.setTitre("s".repeat(Constant.STRING_COMMENT_MAX));

        // WHEN
        Set<ConstraintViolation<ExperienceDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeValid_whenDatedebIsNotSet() {
        // GIVEN
        ExperienceDTO value = new ExperienceDTO();
        value.setDatefin(LocalDate.now());
        value.setTitre("s".repeat(Constant.STRING_COMMENT_MAX));

        // WHEN
        Set<ConstraintViolation<ExperienceDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeValid_whenDatefinIsNotSet() {
        // GIVEN
        ExperienceDTO value = new ExperienceDTO();
        value.setDatedeb(LocalDate.now());
        value.setTitre("s".repeat(Constant.STRING_COMMENT_MAX));

        // WHEN
        Set<ConstraintViolation<ExperienceDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeValid_whenTitleNotSet() {
        // GIVEN
        ExperienceDTO value = new ExperienceDTO();
        value.setDatedeb(LocalDate.now());
        value.setDatefin(LocalDate.now());

        // WHEN
        Set<ConstraintViolation<ExperienceDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeValid_whenTitreExceed128() {
        // GIVEN
        ExperienceDTO value = new ExperienceDTO();
        value.setDatedeb(LocalDate.now());
        value.setDatefin(LocalDate.now());
        value.setTitre("s".repeat(Constant.STRING_COMMENT_MAX + 1));

        // WHEN
        Set<ConstraintViolation<ExperienceDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeValid_whenTitreIsBlank() {
        // GIVEN
        ExperienceDTO value = new ExperienceDTO();
        value.setDatedeb(LocalDate.now());
        value.setDatefin(LocalDate.now());
        value.setTitre("          ");

        // WHEN
        Set<ConstraintViolation<ExperienceDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }
}
