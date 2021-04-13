package fr.univ.rouen.cv21rest.controller;

import fr.univ.rouen.cv21rest.exception.CVAlreadyExistsException;
import fr.univ.rouen.cv21rest.exception.CVNotFoundException;
import fr.univ.rouen.cv21rest.exception.ErrorResponse;
import fr.univ.rouen.cv21rest.exception.InvalidCVException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(CVNotFoundException.class)
    public ResponseEntity<ErrorResponse> CVNotFoundExceptionHandler(Exception e) {
        return buildErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCVException.class)
    public ResponseEntity<ErrorResponse> InvalidCVExceptionHandler(Exception e) {
        return buildErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CVAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> CVAlreadyExistsExceptionHandler(Exception e) {
        return buildErrorResponse(e.getMessage(), HttpStatus.CONFLICT);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(String message, HttpStatus status) {
        return ResponseEntity.status(status)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .body(new ErrorResponse(message));
    }
}
