package fr.univ.rouen.cv21rest;

import fr.univ.rouen.cv21rest.util.CVParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@SpringBootTest
class Cv21restApplicationTests {

	@Autowired
	private CVParser cvParser;

	@Autowired
	private ResourceLoader loader;

	@Test
	void contextLoads() {
	}

	@Test
	void test_with_sax() throws IOException, SAXException {
		Resource r = loader.getResource("cv21.2.xml");
		if (! cvParser.isValid(r.getInputStream())) {
			throw new SAXException("not valid file");
		}
	}
}
