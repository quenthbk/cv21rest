package fr.univ.rouen.cv21rest.exception;

/**
 * Erreur émise si un CV fourni est invalide
 */
public class InvalidCVException extends RuntimeException {

    /**
     *
     * @param message permettant de comprendre l'exception
     */
    public InvalidCVException(String message) {
        super(message);
    }

    /**
     *
     * @param message permettant de comprendre l'exception
     * @param cause de l'exception émise
     */
    public InvalidCVException(String message, Throwable cause) {
        super(message, cause);
    }
}
