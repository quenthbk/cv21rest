package fr.univ.rouen.cv21rest.exception;

/**
 * Exception émise si un CV est déjà présent
 */
public class CVAlreadyExistsException extends RuntimeException {

    /**
     *
     * @param message permettant de comprendre l'exception
     */
    public CVAlreadyExistsException(String message) {
        super(message);
    }

    /**
     *
     * @param message permettant de comprendre l'exception
     * @param cause de l'exception émise
     */
    public CVAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
