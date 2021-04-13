package fr.univ.rouen.cv21rest.repository;

import fr.univ.rouen.cv21rest.model.CV;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CVRepository extends MongoRepository<CV, String> {}
