package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.*;

@SpringBootTest
public class CVDTOTest {

    @Autowired
    private Validator validator;

    private final IdentityDTO validIdentity;

    private final VariousDTO validVarious;

    private final ExperienceDTO validExperience;

    private final CompetencesDTO validCompetences;

    private final ObjectiveDTO validObjective;

    public CVDTOTest() {
        validIdentity = new IdentityDTO();
        validIdentity.setPhoneNumber("0606060606");
        validIdentity.setFirstname("sdde");
        validIdentity.setLastname("dsdd");
        validIdentity.setEmail("test@test.com");
        validIdentity.setGender(Gender.WOMAN);

        LanguageDTO language = new LanguageDTO();
        language.setCertification(LanguageCertification.CLES);
        language.setName("lang");
        language.setGrade(50);
        language.setLevel(LanguageLevel.A1);
        validVarious = new VariousDTO();
        validVarious.setLanguages(Collections.singletonList(language));

        validExperience = new ExperienceDTO();
        validExperience.setDateStart(LocalDate.now());
        validExperience.setDateEnd(LocalDate.now());
        validExperience.setTitle("s");

        DegreeDTO validDegree = new DegreeDTO();
        validDegree.setDate(LocalDate.now());
        validDegree.setTitle("s");
        validDegree.setInstitution("s");
        validDegree.setLevel(DegreeLevel.I);

        validCompetences = new CompetencesDTO();
        validCompetences.setDegrees(Collections.singletonList(validDegree));

        validObjective = new ObjectiveDTO();
        validObjective.setJob("s");
        validObjective.setRequest(ObjectiveRequest.EMPLOYMENT);
    }

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setCompetences(validCompetences);
        value.setExperiences(Collections.singletonList(validExperience));
        value.setIdentity(validIdentity);
        value.setObjective(validObjective);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenObjectifIsNotSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setCompetences(validCompetences);
        value.setExperiences(Collections.singletonList(validExperience));
        value.setIdentity(validIdentity);


        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }

    @Test
    public void shouldBeInvalid_whenObjectiveIsInvalid() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setCompetences(validCompetences);
        value.setExperiences(Collections.singletonList(validExperience));
        value.setIdentity(validIdentity);
        value.setObjective(new ObjectiveDTO());

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }

    @Test
    public void shouldBeInvalid_whenProfIsNotSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setCompetences(validCompetences);
        value.setIdentity(validIdentity);
        value.setObjective(validObjective);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenCompetenceIsNotSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setExperiences(Collections.singletonList(validExperience));
        value.setIdentity(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }

    @Test
    public void shouldBeInvalid_whenIdentityIsNotSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setCompetences(validCompetences);
        value.setExperiences(Collections.singletonList(validExperience));
        value.setObjective(validObjective);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenDiversIsNotSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setCompetences(validCompetences);
        value.setExperiences(Collections.singletonList(validExperience));
        value.setIdentity(validIdentity);
        value.setObjective(validObjective);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenProfIsEmpty() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setCompetences(validCompetences);
        value.setExperiences(new ArrayList<>());
        value.setIdentity(validIdentity);
        value.setObjective(validObjective);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenProfCompetencesIsInvalid() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setCompetences(new CompetencesDTO());
        value.setExperiences(Collections.singletonList(validExperience));
        value.setIdentity(validIdentity);
        value.setObjective(validObjective);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }

    @Test
    public void shouldBeInvalid_whenIdentityIsInvalid() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setCompetences(validCompetences);
        value.setExperiences(Collections.singletonList(validExperience));
        value.setIdentity(new IdentityDTO());
        value.setObjective(validObjective);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }

    @Test
    public void shouldBeInvalid_whenDiversIsInvalid() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(new VariousDTO());
        value.setCompetences(validCompetences);
        value.setExperiences(Collections.singletonList(validExperience));
        value.setIdentity(validIdentity);
        value.setObjective(validObjective);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }


    @Test
    public void shouldBeInvalid_whenExperienceIsInvalid() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setVarious(validVarious);
        value.setCompetences(validCompetences);
        value.setExperiences(Collections.singletonList(new ExperienceDTO()));
        value.setIdentity(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }
}
