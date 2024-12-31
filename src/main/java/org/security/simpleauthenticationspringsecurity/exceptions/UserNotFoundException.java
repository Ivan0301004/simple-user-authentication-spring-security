package org.security.simpleauthenticationspringsecurity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDateTime;

public class UserNotFoundException extends UsernameNotFoundException {

    private final HttpStatus httpStatus;
    private final LocalDateTime localDateTime;

    public UserNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.localDateTime = LocalDateTime.now();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
