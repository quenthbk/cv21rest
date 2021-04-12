package fr.univ.rouen.cv21rest.controller;

import fr.univ.rouen.cv21rest.dto.CVDTO;
import fr.univ.rouen.cv21rest.dto.EntityResponseDTO;
import fr.univ.rouen.cv21rest.dto.ResumeDTO;
import fr.univ.rouen.cv21rest.model.CV;
import fr.univ.rouen.cv21rest.model.CVStatus;
import fr.univ.rouen.cv21rest.service.CVService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CVController {

    @Autowired
    private CVService service;

    @Autowired
    private ModelMapper mapper;

    // --------------------------------------------------------------------
    //      GET
    // --------------------------------------------------------------------

    @GetMapping(value = "/htmlcv", produces = MediaType.TEXT_HTML_VALUE)
    public String htmlcv(@RequestParam int id) {
        return "";
    }

    @GetMapping(value = "/cv", produces = MediaType.APPLICATION_XML_VALUE)
    public CVDTO cv(@RequestParam String id) {
        return mapper.map(service.getById(id), CVDTO.class);
    }


    @GetMapping(value = "/resume", produces = MediaType.APPLICATION_XML_VALUE)
    public ResumeDTO resume() {
        return new ResumeDTO(mapList(service.getAll(), CVDTO.class));
    }

    // --------------------------------------------------------------------
    //      POST
    // --------------------------------------------------------------------

    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_XML_VALUE+ ";charset=UTF-8",
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public EntityResponseDTO insert(@Valid @RequestBody CVDTO cv) {
        CV entitySaved = service.create(mapper.map(cv, CV.class));
        System.out.println(entitySaved);
        return new EntityResponseDTO(entitySaved.getId(), CVStatus.INSERTED);
    }

    // --------------------------------------------------------------------
    //      DELETE
    // --------------------------------------------------------------------

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    public EntityResponseDTO delete(@RequestParam String id) {
        service.delete(id);
        return new EntityResponseDTO(id, CVStatus.DELETED);
    }

    // --------------------------------------------------------------------
    //      PUT
    // --------------------------------------------------------------------

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public EntityResponseDTO update(@RequestParam String id, @Valid @RequestBody CVDTO cv) {
        service.update(id, mapper.map(cv, CV.class));
        return new EntityResponseDTO(id, CVStatus.UPDATED);
    }

    // --------------------------------------------------------------------
    //      TOOLS UTILS
    // --------------------------------------------------------------------

    private <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> mapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
