package fr.univ.rouen.cv21rest.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootTest
public class OtherDTOTest {

    @Autowired
    private Validator validator;

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setComment("s".repeat(128));
        other.setTitre("s".repeat(32));

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenCommentIsNotSet() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setTitre("string");

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
        other.setTitre("s".repeat(33));

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenCommentExceed128Char() {
        // GIVEN
        OtherDTO other = new OtherDTO();
        other.setComment("s".repeat(129));
        other.setTitre("s");

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
        other.setTitre("s");

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
        other.setTitre("          ");

        // WHEN
        Set<ConstraintViolation<OtherDTO>> violations =  validator.validate(other);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }
}
