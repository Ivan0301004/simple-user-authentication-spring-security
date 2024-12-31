package org.security.simpleauthenticationspringsecurity.handler;

import org.security.simpleauthenticationspringsecurity.dto.ErrorResponse;
import org.security.simpleauthenticationspringsecurity.exceptions.UserNotFoundException;
import org.security.simpleauthenticationspringsecurity.exceptions.UsernameAlreadyTaken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(UsernameAlreadyTaken.class)
    public ResponseEntity<ErrorResponse> usernameAlreadyTakenResponseEntity(UsernameAlreadyTaken ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getStatus(), ex.getLocalDateTime());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> usernameNotFondEntity(UserNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.getHttpStatus(), ex.getLocalDateTime());
        return ResponseEntity.badRequest().body(response);
    }


}
