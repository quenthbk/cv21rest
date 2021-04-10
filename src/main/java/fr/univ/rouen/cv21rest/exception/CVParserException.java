package fr.univ.rouen.cv21rest.exception;

public class CVParserException extends RuntimeException {

    /**
     *
     * @param message permettant de comprendre l'exception
     */
    public CVParserException(String message) {
        super(message);
    }

    /**
     *
     * @param message permettant de comprendre l'exception
     * @param cause de l'exception émise
     */
    public CVParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
