package fr.univ.rouen.cv21rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ.rouen.cv21rest.dto.CVDTO;
import fr.univ.rouen.cv21rest.validation.CVXMLValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class Cv21restApplicationTests {

	@Autowired
	private ResourceLoader loader;

	@Autowired
	private CVXMLValidator validator;

	@Test
	void contextLoads() {
	}

	@Test
	void test_with_sax() throws IOException, SAXException {

	}

	private String xml = "<cv21:cv21 xmlns:cv21=\"http://univ.fr/cv21\">\n" +
			"  <identite>\n" +
			"    <genre>Mme</genre>\n" +
			"    <nom>test</nom>\n" +
			"    <prenom>test</prenom>\n" +
			"    <!--Optional:-->\n" +
			"    <tel>0602020202</tel>\n" +
			"    <!--Optional:-->\n" +
			"    <mel>test@test.com</mel>\n" +
			"  </identite>\n" +
			"  <objectif statut=\"stage\">test</objectif>\n" +
			"  <!--Optional:-->\n" +
			"  <prof>\n" +
			"    <!--1 or more repetitions:-->\n" +
			"    <expe>\n" +
			"      <datedeb>2013-11-23</datedeb>\n" +
			"      <datefin>2014-06-09</datefin>\n" +
			"      <titre>string</titre>\n" +
			"    </expe>\n" +
			"  </prof>\n" +
			"  <competences>\n" +
			"    <!--1 to 5 repetitions:-->\n" +
			"    <diplôme niveau=\"IV\">\n" +
			"      <date>2009-05-16</date>\n" +
			"      <titre>string</titre>\n" +
			"      <etab>string</etab>\n" +
			"    </diplôme>\n" +
			"    <!--Zero or more repetitions:-->\n" +
			"    <certif>\n" +
			"      <datedeb>2003-08-09</datedeb>\n" +
			"      <!--Optional:-->\n" +
			"      <datefin>2012-09-13</datefin>\n" +
			"      <titre>string</titre>\n" +
			"    </certif>\n" +
			"  </competences>\n" +
			"  <divers>\n" +
			"    <!--1 to 5 repetitions:-->\n" +
			"    <lv lang=\"anySimpleType\" cert=\"MAT\" nivs=\"C2\" nivi=\"201\">string</lv>\n" +
			"    <!--0 to 3 repetitions:-->\n" +
			"    <autre titre=\"string\" comment=\"string\">string</autre>\n" +
			"  </divers>\n" +
			"</cv21:cv21>";
}
