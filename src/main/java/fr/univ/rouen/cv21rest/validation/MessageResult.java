package fr.univ.rouen.cv21rest.validation;

import java.io.Serializable;

public class MessageResult implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
