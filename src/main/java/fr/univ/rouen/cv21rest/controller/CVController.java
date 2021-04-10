package fr.univ.rouen.cv21rest.controller;

import fr.univ.rouen.cv21rest.dto.CVDTO;
import fr.univ.rouen.cv21rest.dto.EntityResponseDTO;
import fr.univ.rouen.cv21rest.model.CVStatus;
import fr.univ.rouen.cv21rest.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CVController {

    @Autowired
    public CVService service;

    // --------------------------------------------------------------------
    //      GET
    // --------------------------------------------------------------------
    @GetMapping("/")
    public String home() {
        // TODO
        return "";
    }

    @GetMapping("/help")
    public String help() {
        return "";
    }

    @GetMapping(value = "/resume", produces = MediaType.APPLICATION_XML_VALUE)
    public List<CVDTO> resume() {
        return service.getAll();
    }

    @GetMapping(value = "/cv", produces = MediaType.APPLICATION_XML_VALUE)
    public CVDTO cv(@RequestParam long id) {
        return service.getById(id);
    }

    @GetMapping(value = "/htmlcv", produces = MediaType.TEXT_HTML_VALUE)
    public String htmlcv(@RequestParam int id) {
        CVDTO cv = service.getById(id);
        return "";
    }

    // --------------------------------------------------------------------
    //      POST
    // --------------------------------------------------------------------

    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public EntityResponseDTO insert(@RequestBody CVDTO cv) {
        CVDTO cvSaved =  service.create(cv);
        return new EntityResponseDTO(cvSaved.getId(), CVStatus.INSERTED);
    }

    // --------------------------------------------------------------------
    //      DELETE
    // --------------------------------------------------------------------

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    public EntityResponseDTO delete(@RequestParam long id) {
        service.delete(id);
        return new EntityResponseDTO(id, CVStatus.DELETED);
    }

    // --------------------------------------------------------------------
    //      PUT
    // --------------------------------------------------------------------

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public EntityResponseDTO update(@RequestParam long id, @RequestBody CVDTO cv) {
        return new EntityResponseDTO(id, CVStatus.UPDATED);
    }
}
