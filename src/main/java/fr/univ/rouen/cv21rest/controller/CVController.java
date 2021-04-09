package fr.univ.rouen.cv21rest.controller;

import fr.univ.rouen.cv21rest.dto.CVDto;
import fr.univ.rouen.cv21rest.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        // TODO
        return "";
    }

    @GetMapping("/resume")
    public String resume() {
        // TODO
        return "";
    }

    @GetMapping("/cv")
    public String cv(@RequestParam int id) {
        CVDto cv = service.getById(id);
        return "";
    }

    @GetMapping("/htmlcv")
    public String htmlcv(@RequestParam int id) {
        CVDto cv = service.getById(id);
        return "";
    }

    // --------------------------------------------------------------------
    //      POST
    // --------------------------------------------------------------------
}
