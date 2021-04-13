package fr.univ.rouen.cv21rest.validation;

import fr.univ.rouen.cv21rest.dto.CVDTO;

public interface CVXMLValidator {

    boolean isValid(CVDTO cv, MessageResult result);
}
