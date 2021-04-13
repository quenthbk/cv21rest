package fr.univ.rouen.cv21rest.validation;

import fr.univ.rouen.cv21rest.dto.CVDTO;

import java.io.InputStream;

public interface CVXMLValidator {

    boolean isValid(CVDTO cv);

    boolean isValid(InputStream cv);

    String getMessage();
}
