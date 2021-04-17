package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.DegreeLevel;
import fr.univ.rouen.cv21rest.validation.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

public class DegreeDTOTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        DegreeDTO value = new DegreeDTO();
        value.setDate(LocalDate.now());
        value.setTitle("s".repeat(Constant.STRING_NAME_MAX));
        value.setInstitution("s".repeat(Constant.STRING_NAME_MAX));
        value.setLevel(DegreeLevel.I);

        // WHEN
        Set<ConstraintViolation<DegreeDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenTitleExceed32() {
        // GIVEN
        DegreeDTO value = new DegreeDTO();
        value.setDate(LocalDate.now());
        value.setTitle("s".repeat(Constant.STRING_NAME_MAX + 1));
        value.setInstitution("s".repeat(Constant.STRING_NAME_MAX));
        value.setLevel(DegreeLevel.I);

        // WHEN
        Set<ConstraintViolation<DegreeDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenEtabExceed32() {
        // GIVEN
        DegreeDTO value = new DegreeDTO();
        value.setDate(LocalDate.now());
        value.setTitle("s".repeat(Constant.STRING_NAME_MAX));
        value.setInstitution("s".repeat(Constant.STRING_NAME_MAX + 1));
        value.setLevel(DegreeLevel.I);

        // WHEN
        Set<ConstraintViolation<DegreeDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenEtabIsNotSet() {
        // GIVEN
        DegreeDTO value = new DegreeDTO();
        value.setDate(LocalDate.now());
        value.setTitle("s".repeat(Constant.STRING_NAME_MAX));
        value.setLevel(DegreeLevel.I);

        // WHEN
        Set<ConstraintViolation<DegreeDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenTitleIsNotSet() {
        // GIVEN
        DegreeDTO value = new DegreeDTO();
        value.setDate(LocalDate.now());
        value.setInstitution("s".repeat(Constant.STRING_NAME_MAX));
        value.setLevel(DegreeLevel.I);

        // WHEN
        Set<ConstraintViolation<DegreeDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenDateIsNotSet() {
        // GIVEN
        DegreeDTO value = new DegreeDTO();
        value.setTitle("s".repeat(Constant.STRING_NAME_MAX));
        value.setInstitution("s".repeat(Constant.STRING_NAME_MAX));
        value.setLevel(DegreeLevel.I);

        // WHEN
        Set<ConstraintViolation<DegreeDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenDegreeIsNotSet() {
        // GIVEN
        DegreeDTO value = new DegreeDTO();
        value.setDate(LocalDate.now());
        value.setTitle("s".repeat(Constant.STRING_NAME_MAX));
        value.setInstitution("s".repeat(Constant.STRING_NAME_MAX));

        // WHEN
        Set<ConstraintViolation<DegreeDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }
}
