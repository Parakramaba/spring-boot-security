package com.parakramaba.springbootsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A ResourceNotFoundException thrown when a certain resource that is requested by the API call cannot be found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    /**
     *
     */
    public ResourceNotFoundException() { super();}

    /**
     *
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
