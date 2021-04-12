package fr.univ.rouen.cv21rest.repository;

import fr.univ.rouen.cv21rest.model.CV;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CVRepository extends MongoRepository<CV, String> { }
