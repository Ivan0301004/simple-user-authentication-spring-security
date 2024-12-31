package org.security.simpleauthenticationspringsecurity.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class UsernameAlreadyTaken extends RuntimeException {

    private final HttpStatus status;
    private final LocalDateTime localDateTime;

    public UsernameAlreadyTaken(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.localDateTime = LocalDateTime.now();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

}
