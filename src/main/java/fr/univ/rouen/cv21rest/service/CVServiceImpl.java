package fr.univ.rouen.cv21rest.service;

import fr.univ.rouen.cv21rest.exception.CVAlreadyExistsException;
import fr.univ.rouen.cv21rest.exception.CVNotFoundException;
import fr.univ.rouen.cv21rest.model.CV;
import fr.univ.rouen.cv21rest.model.Degree;
import fr.univ.rouen.cv21rest.repository.CVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CVServiceImpl implements CVService {


    private final CVRepository repository;

    @Autowired
    private MongoOperations mongo;

    @Autowired
    public CVServiceImpl(CVRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CV> getAll() {
        List<CV> cvs = repository.findAll();
        for (CV cv : cvs) {
            sortCVItem(cv);
        }
        return cvs;
    }

    @Override
    public CV getById(String id) {
        Optional<CV> cv =  repository.findById(id);
        if (cv.isEmpty()) {
            throw new CVNotFoundException("Le CV est introuvable");
        }

        sortCVItem(cv.get());
        return cv.get();
    }

    @Override
    public CV create(CV cv) {
        // Requêtes permettant de rechercher par critère
        Query query = new Query();
        query.addCriteria(
                Criteria.where("identity.firstname").is(cv.getIdentity().getFirstname())
                        .and("identity.lastname").is(cv.getIdentity().getLastname())
                        .and("objective.job").is(cv.getObjective().getJob())
                        .and("objective.request").is(cv.getObjective().getRequest())
        );
        List<CV> cvs = mongo.find(query, CV.class);

        // Si la liste n'est pas vide, alors il y a un conflit
        if (! cvs.isEmpty()) {
            throw new CVAlreadyExistsException(
                    "Ce CV existe déjà à l'id : " + cvs.get(0).getId());
        }

        sortCVItem(cv);
        return repository.save(cv);
    }

    @Override
    public CV update(String id, CV cv) {
        if (! repository.existsById(id)) {
            throw new CVNotFoundException("Le CV est introuvable");
        }

        // Requêtes permettant de rechercher par critère en retirant l'id
        Query query = new Query();
        query.addCriteria(
                Criteria.where("identity.firstname").is(cv.getIdentity().getFirstname())
                        .and("identity.lastname").is(cv.getIdentity().getLastname())
                        .and("objective.job").is(cv.getObjective().getJob())
                        .and("objective.request").is(cv.getObjective().getRequest())
                        .and("id").nin(id)
        );
        List<CV> cvs = mongo.find(query, CV.class);

        if (! cvs.isEmpty()) {
            throw new CVAlreadyExistsException(
                    "Il existe déjà un cv comme celui-ci à l'id : " + cvs.get(0).getId());
        }

        sortCVItem(cv);

        cv.setId(id);
        return repository.save(cv);

    }

    @Override
    public void delete(String id) {
        if (! repository.existsById(id)) {
            throw new CVNotFoundException("Le CV est introuvable");
        }
        repository.deleteById(id);
    }

    // Petite méthode pour trier les éléments du cv
    private static void sortCVItem(CV cv) {
        cv.getDegrees().sort(Degree::compareTo);
    }
}
