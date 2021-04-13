package fr.univ.rouen.cv21rest.controller;

import fr.univ.rouen.cv21rest.dto.CVDTO;
import fr.univ.rouen.cv21rest.dto.CVResumedDTO;
import fr.univ.rouen.cv21rest.dto.EntityResponseDTO;
import fr.univ.rouen.cv21rest.dto.ResumeDTO;
import fr.univ.rouen.cv21rest.exception.InvalidCVException;
import fr.univ.rouen.cv21rest.model.CV;
import fr.univ.rouen.cv21rest.model.CVStatus;
import fr.univ.rouen.cv21rest.service.CVService;
import fr.univ.rouen.cv21rest.validation.CVXMLValidator;
import fr.univ.rouen.cv21rest.validation.MessageResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CVController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CVController.class);

    @Autowired
    private CVService service;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TemplateEngine engine;

    @Autowired
    private CVXMLValidator validator;

    // --------------------------------------------------------------------
    //      GET
    // --------------------------------------------------------------------

    @ApiOperation(value = "Renvoie un CV au format html grâce à son ID à condition que celui-ci existe")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Flux HTML du contenu complet du CV dont l’identifiant est <id>"),
            @ApiResponse(code = 404, message = "Le CV est introuvable")
    })
    @GetMapping(value = "/htmlcv", produces = MediaType.TEXT_HTML_VALUE)
    public String htmlcv(@RequestParam String id) {
        LOGGER.info("GET d'un cv au format html");
        // Récupération du CV
        CV cv = service.getById(id);

        // Préparation du template
        Context context = new Context();
        context.setVariable("identity", cv.getIdentity());
        context.setVariable("experiences", cv.getExperiences());
        context.setVariable("degrees", cv.getDegrees());
        context.setVariable("certifications", cv.getCertifications());
        context.setVariable("languages", cv.getLanguages());
        context.setVariable("others", cv.getOthers());
        context.setVariable("objective", cv.getObjective());

        // Génération du template
        return engine.process("cv", context);
    }

    @ApiOperation(value = "Retourne le contenu complet du CV dont l’identifiant est {id}")
    @GetMapping(value = "/cv", produces = MediaType.APPLICATION_XML_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Flux XML conforme au schéma XSD définissant le format CV21"),
            @ApiResponse(code = 404, message = "Le CV est introuvable")
    })
    public CVDTO cv(@RequestParam String id) {
        LOGGER.info("GET d'un cv au format xml");
        System.out.println(service.getById(id));
        return mapper.map(service.getById(id), CVDTO.class);
    }

    @ApiOperation(value = "Affiche la liste des CV stockées")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Flux XML, List résumée des CV présents dans la base.")
    })
    @GetMapping(value = "/resume", produces = MediaType.APPLICATION_XML_VALUE)

    public ResumeDTO resume() {
        // TODO Liste résumée des CV présents dans la base.
        LOGGER.info("GET de tous les CV présents dans la base de donnée");
        System.out.println(new ResumeDTO(mapList(service.getAll(), CVResumedDTO.class)));
        return new ResumeDTO(mapList(service.getAll(), CVResumedDTO.class));
    }

    // --------------------------------------------------------------------
    //      POST
    // --------------------------------------------------------------------

    @ApiOperation(value = "Insertion d'un CV dans la base de donnée. ",
            notes = "Le flux reçu est validé par le schéma XSD de définition CV21\n" +
            "Si le flux est déjà présent (nom, prénom et objectif identique) alors une indication d’erreur est " +
            "retournée. Si l’opération réussie, alors le flux est ajouté à la base et sa persistance est assurée. " +
            "La valeur d'identifiant est automatiquement créée si l'insertion est effectuée.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Le CV a bien été enregistré, le status de retour sera égal à INSERTED"),
            @ApiResponse(code = 400, message = "Le flux XML est incorrect ou ne correspond pas au format XSD"),
            @ApiResponse(code = 409, message = "Un CV déjà existant est présent dans la base de donnée")
    })
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_XML_VALUE+ ";charset=UTF-8",
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public EntityResponseDTO insert(@RequestBody CVDTO cv) {
        LOGGER.info("POST un nouveau CV");
        MessageResult result = new MessageResult();
        if (! validator.isValid(cv, result)) {
            throw new InvalidCVException(result.toString());
        }

        CV entitySaved = service.create(mapper.map(cv, CV.class));
        return new EntityResponseDTO(entitySaved.getId(), CVStatus.INSERTED);
    }

    // --------------------------------------------------------------------
    //      DELETE
    // --------------------------------------------------------------------

    @ApiOperation(value = "Suppression du CV dont l’identifiant est <id>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Le CV a bien été supprimé, le status de retour sera égal à DELETED"),
            @ApiResponse(code = 404, message = "Un CV n'est pas présent dans la base de donnée")
    })
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    public EntityResponseDTO delete(@RequestParam String id) {
        LOGGER.info("DELETE d'un cv à l'id " + id);
        service.delete(id);
        return new EntityResponseDTO(id, CVStatus.DELETED);
    }

    // --------------------------------------------------------------------
    //      PUT
    // --------------------------------------------------------------------

    @ApiOperation(value = "Mise à jour du CV dont l’identifiant est <id> ",
            notes = "Le flux reçu est validé par le schéma XSD de définition CV21\n" +
            "Si l’opération réussie, alors le flux est ajouté à la base et sa persistance est assurée")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Le CV a bien été enregistré, le status de retour sera égal à UPDATED"),
            @ApiResponse(code = 400, message = "Le flux XML est incorrect ou ne correspond pas au format XSD"),
            @ApiResponse(code = 404, message = "Un CV n'est pas présent dans la base de donnée")
    })
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public EntityResponseDTO update(@RequestParam String id, @RequestBody CVDTO cv) {
        LOGGER.info("UPDATE d'un cv");
        MessageResult result = new MessageResult();
        if (! validator.isValid(cv, result)) {
            throw new InvalidCVException(result.toString());
        }

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
