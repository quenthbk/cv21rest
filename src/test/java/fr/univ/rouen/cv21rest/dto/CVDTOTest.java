package fr.univ.rouen.cv21rest.dto;

import fr.univ.rouen.cv21rest.model.*;
import nonapi.io.github.classgraph.json.Id;
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

    public CVDTOTest() {
        validIdentity = new IdentityDTO();
        validIdentity.setTel("0606060606");
        validIdentity.setPrenom("sdde");
        validIdentity.setNom("dsdd");
        validIdentity.setMel("test@test.com");
        validIdentity.setGenre(Gender.WOMAN);

        LanguageDTO language = new LanguageDTO();
        language.setCert(Certification.CLES);
        language.setLang("lang");
        language.setNivi(50);
        language.setNivs(LanguageLevel.A1);
        validVarious = new VariousDTO();
        validVarious.setLanguages(Collections.singletonList(language));

        validExperience = new ExperienceDTO();
        validExperience.setDatedeb(LocalDate.now());
        validExperience.setDatefin(LocalDate.now());
        validExperience.setTitre("s");

        DegreeDTO validDegree = new DegreeDTO();
        validDegree.setDate(LocalDate.now());
        validDegree.setTitre("s");
        validDegree.setEtab("s");
        validDegree.setNiveau(DegreeLevel.I);

        validCompetences = new CompetencesDTO();
        validCompetences.setDegrees(Collections.singletonList(validDegree));
    }

    @Test
    public void shouldBeValid_whenAllValidParamSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(validVarious);
        value.setCompetences(validCompetences);
        value.setProf(Collections.singletonList(validExperience));
        value.setIdentite(validIdentity);
        value.setObjectif(Objective.INTERNSHIP);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeValid_whenObjectifIsNotSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(validVarious);
        value.setCompetences(validCompetences);
        value.setProf(Collections.singletonList(validExperience));
        value.setIdentite(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void shouldBeInvalid_whenProfIsNotSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(validVarious);
        value.setCompetences(validCompetences);
        value.setIdentite(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenCompetenceIsNotSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(validVarious);
        value.setProf(Collections.singletonList(validExperience));
        value.setIdentite(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }

    @Test
    public void shouldBeInvalid_whenIdentityIsNotSet() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(validVarious);
        value.setCompetences(validCompetences);
        value.setProf(Collections.singletonList(validExperience));

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
        value.setProf(Collections.singletonList(validExperience));
        value.setIdentite(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenProfIsEmpty() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(validVarious);
        value.setCompetences(validCompetences);
        value.setProf(new ArrayList<>());
        value.setIdentite(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }

    @Test
    public void shouldBeInvalid_whenProfCompetencesIsInvalid() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(validVarious);
        value.setCompetences(new CompetencesDTO());
        value.setProf(Collections.singletonList(validExperience));
        value.setIdentite(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }

    @Test
    public void shouldBeInvalid_whenIdentityIsInvalid() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(validVarious);
        value.setCompetences(validCompetences);
        value.setProf(Collections.singletonList(validExperience));
        value.setIdentite(new IdentityDTO());

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }

    @Test
    public void shouldBeInvalid_whenDiversIsInvalid() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(new VariousDTO());
        value.setCompetences(validCompetences);
        value.setProf(Collections.singletonList(validExperience));
        value.setIdentite(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).hasSize(1);
    }


    @Test
    public void shouldBeInvalid_whenExperienceIsInvalid() {
        // GIVEN
        CVDTO value = new CVDTO();
        value.setDivers(validVarious);
        value.setCompetences(validCompetences);
        value.setProf(Collections.singletonList(new ExperienceDTO()));
        value.setIdentite(validIdentity);

        // WHEN
        Set<ConstraintViolation<CVDTO>> violations =  validator.validate(value);
        // THEN
        Assertions.assertThat(violations).isNotEmpty();
    }
}
