package com.connected.demonewerrorhandling.exception;

import com.connected.demonewerrorhandling.modelResponse.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler  {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex) {
        System.out.println(ex.getMessage());

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                        .message("The user id you sent is invalid / not match")
                        .errors(new String[]{ex.getMessage()})
                        .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        System.out.println(ex.getMessage());

        String[] errors = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + " " + f.getDefaultMessage())
                .toArray(String[]::new);

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                        .message("Arguments not valid / match")
                        .errors(errors)
                        .build()
                );
    }
}
