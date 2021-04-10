package fr.univ.rouen.cv21rest.exception;

/**
 * Exception émise si un CV demandé n'existe pas
 */
public class CVNotFoundException extends RuntimeException {

    /**
     *
     * @param message permettant de comprendre l'exception
     */
    public CVNotFoundException(String message) {
        super(message);
    }

    /**
     *
     * @param message permettant de comprendre l'exception
     * @param cause de l'exception émise
     */
    public CVNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
