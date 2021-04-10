package fr.univ.rouen.cv21rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univ.rouen.cv21rest.dto.CVDTO;
import fr.univ.rouen.cv21rest.exception.CVParserException;
import fr.univ.rouen.cv21rest.exception.InvalidCVException;
import fr.univ.rouen.cv21rest.util.CVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.List;

@Service
public class CVServiceImpl implements CVService {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private CVParser cvParser;

    @Override
    public List<CVDTO> getAll() {
        return null;
    }

    @Override
    public CVDTO getById(long id) {
        return null;
    }

    @Override
    public CVDTO create(CVDTO cv) {
        if(! xmlCVIsValid(cv)) {
            throw new InvalidCVException("Le cv ne respecte pas le schema spécifié par le xsd");
        }

        // SAVE CV
        return cv;
    }

    @Override
    public CVDTO update(long id, CVDTO cv) {
        if(! xmlCVIsValid(cv)) {
            throw new InvalidCVException("Le cv ne respecte pas le schema spécifié par le xsd");
        }

        // SAVE CV
        return null;
    }

    @Override
    public void delete(long id) {

    }

    private boolean xmlCVIsValid(CVDTO cv) {
        try {
            byte[] bytes = mapper.writeValueAsBytes(cv);
            InputStream in = new ByteArrayInputStream(bytes);
            return cvParser.isValid(in);
        } catch (SAXException | IOException e) {
            throw new CVParserException("Un problème est survenu lors de la validation du format xml", e);
        }
    }
}
