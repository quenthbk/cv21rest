package fr.univ.rouen.cv21rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import fr.univ.rouen.cv21rest.dto.CVDTO;
import fr.univ.rouen.cv21rest.exception.CVNotFoundException;
import fr.univ.rouen.cv21rest.exception.CVParserException;
import fr.univ.rouen.cv21rest.exception.InvalidCVException;
import fr.univ.rouen.cv21rest.model.CV;
import fr.univ.rouen.cv21rest.repository.CVRepository;
import fr.univ.rouen.cv21rest.util.CVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CVServiceImpl implements CVService {


    private final CVRepository repository;

    @Autowired
    public CVServiceImpl(CVRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CV> getAll() {
        return repository.findAll();
    }

    @Override
    public CV getById(String id) {
        Optional<CV> cv =  repository.findById(id);
        if (cv.isEmpty()) {
            throw new CVNotFoundException("Le CV est introuvable");
        }
        return cv.get();
    }

    @Override
    public CV create(CV cv) {
        return repository.save(cv);
    }

    @Override
    public CV update(String id, CV cv) {
        if (repository.existsById(id)) {
            cv.setId(id);
            return repository.save(cv);
        }
        throw new CVNotFoundException("Le CV est introuvable");
    }

    @Override
    public void delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new CVNotFoundException("Le CV est introuvable");
    }
}
