package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.Gender;
import fr.univ.rouen.cv21rest.validation.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class IdentityDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("test@test.com");
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX));
        value.setFirstname("s".repeat(Constant.STRING_NAME_MAX));
        value.setPhoneNumber("0606606002");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeValid_whenEmailIsNotSet() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX));
        value.setFirstname("s".repeat(Constant.STRING_NAME_MAX));
        value.setPhoneNumber("0606606002");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeValid_whenPhoneIsNotSet() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("test@test.com");
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX));
        value.setFirstname("s".repeat(Constant.STRING_NAME_MAX));

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenPhoneIsInvalid() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("test@test.com");
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX));
        value.setFirstname("s".repeat(Constant.STRING_NAME_MAX));
        value.setPhoneNumber("060602");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenEmailIsInvalid() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("testtest.com");
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX));
        value.setFirstname("s".repeat(Constant.STRING_NAME_MAX));
        value.setPhoneNumber("0632060602");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenGenderIsNotSet() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setEmail("test@test.com");
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX));
        value.setFirstname("s".repeat(Constant.STRING_NAME_MAX));
        value.setPhoneNumber("0632060602");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenNomIsNotSet() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("test@test.com");
        value.setFirstname("s".repeat(Constant.STRING_NAME_MAX));
        value.setPhoneNumber("0632060602");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenPrenomIsNotSet() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("test@test.com");
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX));
        value.setPhoneNumber("0632060602");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenPrenomExceed32Char() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("test@test.com");
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX));
        value.setFirstname("s".repeat(Constant.STRING_NAME_MAX + 1));
        value.setPhoneNumber("0632060602");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenNomExceed32Char() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("test@test.com");
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX + 1));
        value.setFirstname("s".repeat(Constant.STRING_NAME_MAX));
        value.setPhoneNumber("0632060602");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenNomIsBlank() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("test@test.com");
        value.setLastname("       ");
        value.setFirstname("s");
        value.setPhoneNumber("0632060602");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenPrenomIsBlank() {
        // GIVEN
        IdentityDTO value = new IdentityDTO();
        value.setGender(Gender.WOMAN);
        value.setEmail("test@test.com");
        value.setLastname("s".repeat(Constant.STRING_NAME_MAX));
        value.setFirstname("    ");
        value.setPhoneNumber("0632060602");

        // WHEN
        Set<ConstraintViolation<IdentityDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }
}
