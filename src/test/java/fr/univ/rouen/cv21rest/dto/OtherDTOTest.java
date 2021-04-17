package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.validation.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class OtherDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setComment("s".repeat(Constant.STRING_COMMENT_MAX));
        other.setTitle("s".repeat(Constant.STRING_NAME_MAX));

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenCommentIsNotSet() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setTitle("string");

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenTitreIsNotSet() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setComment("string");

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenTitreExceed32Char() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setComment("string");
        other.setTitle("s".repeat(Constant.STRING_NAME_MAX + 1));

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenCommentExceed128Char() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setComment("s".repeat(Constant.STRING_COMMENT_MAX + 1));
        other.setTitle("s");

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenCommentIsBlank() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setComment("     ");
        other.setTitle("s");

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenTitleIsBlank() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setComment("  fg   ");
        other.setTitle("          ");

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }
}
