package fr.univ.rouen.cv21rest.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
class SwaggerConfig {

    @Autowired(required = false)
    private BuildProperties buildProperties;


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new MyApiDoc())
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.univ.rouen.cv21rest"))
                .paths(PathSelectors.any())
                .build();
    }

    class MyApiDoc extends ApiInfo {
        static final String TITLE = "Documentation";
        static final String DESCRIPTION = "Page contenant les informations d'aide de l'application ainsi " +
                "que la description de chaque routes et le format accepté.";
        static final String TERM_OF_SERVICE = "";
        static final String AUTHOR = "Quentin Holubeik";
        static final String EMAIL = "quentin.holubeik@etu.univ-rouen.fr";

        public MyApiDoc() {
            super(TITLE, DESCRIPTION,
                    buildProperties != null ? buildProperties.getVersion() : "SNAPSHOT",
                    TERM_OF_SERVICE, new Contact(AUTHOR, "", EMAIL),
                    "", "", new ArrayList<>());
        }
    }
}

