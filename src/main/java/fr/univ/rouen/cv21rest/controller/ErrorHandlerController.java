package fr.univ.rouen.cv21rest.controller;

import com.mongodb.MongoTimeoutException;
import fr.univ.rouen.cv21rest.exception.CVAlreadyExistsException;
import fr.univ.rouen.cv21rest.exception.CVNotFoundException;
import fr.univ.rouen.cv21rest.exception.ErrorResponse;
import fr.univ.rouen.cv21rest.exception.InvalidCVException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandlerController.class);

    @ExceptionHandler(CVNotFoundException.class)
    public ResponseEntity<ErrorResponse> CVNotFoundExceptionHandler(Exception e) {
        LOGGER.info(e.getMessage());
        return buildErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidCVException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> InvalidCVExceptionHandler(Exception e) {
        LOGGER.info(e.getMessage());
        return buildErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CVAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> CVAlreadyExistsExceptionHandler(Exception e) {
        LOGGER.info(e.getMessage());
        return buildErrorResponse(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MongoTimeoutException.class)
    public ResponseEntity<ErrorResponse> MongoTimeoutException(Exception e) {
        LOGGER.error(e.getMessage());
        return buildErrorResponse("Impossibilité de se connecter à la base de donnée",
                HttpStatus.REQUEST_TIMEOUT);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(String message, HttpStatus status) {
        return ResponseEntity.status(status)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .body(new ErrorResponse(message));
    }
}
