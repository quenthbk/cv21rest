package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.DegreeLevel;
import fr.univ.rouen.cv21rest.model.Objective;
import fr.univ.rouen.cv21rest.model.ObjectiveRequest;
import fr.univ.rouen.cv21rest.validation.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObjectiveDTOTest {

    @Autowired
    private Validator validator;

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        ObjectiveDTO value = new ObjectiveDTO();
        value.setJob("s".repeat(Constant.STRING_NAME_MAX));
        value.setRequest(ObjectiveRequest.EMPLOYMENT);

        // WHEN
        Set<ConstraintViolation<ObjectiveDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenRequestIsNotSet() {
        // GIVEN
        ObjectiveDTO value = new ObjectiveDTO();
        value.setJob("s".repeat(Constant.STRING_NAME_MAX));

        // WHEN
        Set<ConstraintViolation<ObjectiveDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenJobExceed32Char() {
        // GIVEN
        ObjectiveDTO value = new ObjectiveDTO();
        value.setJob("s".repeat(Constant.STRING_NAME_MAX + 1));
        value.setRequest(ObjectiveRequest.EMPLOYMENT);

        // WHEN
        Set<ConstraintViolation<ObjectiveDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenJobIsBlank() {
        // GIVEN
        ObjectiveDTO value = new ObjectiveDTO();
        value.setJob("     ");
        value.setRequest(ObjectiveRequest.EMPLOYMENT);

        // WHEN
        Set<ConstraintViolation<ObjectiveDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenJobIsNotSet() {
        // GIVEN
        ObjectiveDTO value = new ObjectiveDTO();
        value.setRequest(ObjectiveRequest.EMPLOYMENT);

        // WHEN
        Set<ConstraintViolation<ObjectiveDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }
}