package com.example.wogeoji.exception;

import com.example.wogeoji.exception.user.DuplicateEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorCode errorCode;
    private HttpStatus httpStatus;

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEmailException(DuplicateEmailException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponse.of(ErrorCode.valueOf("DUPLICATE_EMAIL")));
    }
}
