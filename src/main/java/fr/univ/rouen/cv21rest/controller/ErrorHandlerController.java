package fr.univ.rouen.cv21rest.controller;

import fr.univ.rouen.cv21rest.exception.CVNotFoundException;
import fr.univ.rouen.cv21rest.exception.ErrorResponse;
import fr.univ.rouen.cv21rest.exception.InvalidCVException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(CVNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse CVNotFoundExceptionHandler(String message) {
        return buildErrorResponse(message);
    }

    @ExceptionHandler(InvalidCVException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse InvalidCVExceptionHandler(String message) {
        return buildErrorResponse(message);
    }


    private ErrorResponse buildErrorResponse(String message) {
        return new ErrorResponse(message);
    }
}
