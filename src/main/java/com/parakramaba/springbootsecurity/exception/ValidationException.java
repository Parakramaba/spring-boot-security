package com.parakramaba.springbootsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A ValidationException thrown when the user request contains data that cannot be accepted by validation logic.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    /**
     *
     */
    public ValidationException() { super();}

    /**
     *
     * @param message
     */
    public ValidationException(String message) {
        super(message);
    }
}
