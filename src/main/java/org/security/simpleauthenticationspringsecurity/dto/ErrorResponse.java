package org.security.simpleauthenticationspringsecurity.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(String message, HttpStatus status, LocalDateTime time) {
}
