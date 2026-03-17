package com.ra.exception;

import com.ra.dto.response.ResponseWrapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                body(ResponseWrapper.error(errors,"Du lieu dau vao khong hop le", HttpStatus.BAD_REQUEST.value()));

    }
    @ExceptionHandler(HttpConflict.class)
    public ResponseEntity<?> handleHttpConflict(HttpConflict ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseWrapper.error(ex.getMessage(),"Du lieu dau vao khong hop le",HttpStatus.CONFLICT.value()));
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseWrapper.error(ex.getMessage(),"Du lieu dau vao khong hop le",HttpStatus.NOT_FOUND.value()));
    }
}
