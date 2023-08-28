package pt.altice.labs.exception;

import java.io.Serializable;

public class NegativeNumberException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public NegativeNumberException() {
    }

    public NegativeNumberException(String message) {
        super(message);
    }

}
