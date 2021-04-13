package fr.univ.rouen.cv21rest.service;

import com.mongodb.ReadPreferenceHedgeOptions;
import com.sun.xml.bind.v2.model.core.ID;
import fr.univ.rouen.cv21rest.model.CV;
import fr.univ.rouen.cv21rest.model.Identity;
import fr.univ.rouen.cv21rest.model.Objective;
import fr.univ.rouen.cv21rest.repository.CVRepository;
import nonapi.io.github.classgraph.json.Id;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CVServiceIntegrationTest {

    @Autowired
    private CVService service;

    private CV cvTest;

    public CVServiceIntegrationTest() {
        cvTest = new CV();
        Identity id = new Identity();
        id.setFirstname("string");
        cvTest.setIdentity(id);
    }

    @Test
    public void findByIdentityAndObjective_shouldFindByFirstnameLastnameJobAndRequest() {
        String lastname = "test";
        String firstname = "test";
        String job = "test";
        String request = "test";

        CV cv = service.create(cvTest);

        //Assertions.assertThat(cvs).isNotEmpty();
    }
}
