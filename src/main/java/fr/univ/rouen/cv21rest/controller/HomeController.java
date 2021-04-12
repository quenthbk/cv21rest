package fr.univ.rouen.cv21rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
public class HomeController {
    @Autowired
    BuildProperties buildProperties;

    @Autowired
    private TemplateEngine engine;

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        Context context = new Context();
        context.setVariable("version", buildProperties.getVersion());
        context.setVariable("name", buildProperties.getName());
        return engine.process("index", context);
    }
}
