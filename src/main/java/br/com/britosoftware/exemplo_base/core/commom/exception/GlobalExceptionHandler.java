package br.com.britosoftware.exemplo_base.core.commom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExemploRestException.class)
    public ResponseEntity<Object> handleExemploRestException(ExemploRestException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        // Se a exceção original for uma ExemploRuntimeException, use sua mensagem
        if (ex.getCause() instanceof ExemploRuntimeException) {
            ExemploRuntimeException exemploEx = (ExemploRuntimeException) ex.getCause();
            body.put("message", ex.getCause().getMessage());
            if (exemploEx.getCodMsg() != null) {
                body.put("code", exemploEx.getCodMsg());
            }
        } else {
            body.put("message", ex.getMessage());
        }

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExemploException.class)
    public ResponseEntity<Object> handleExemploException(ExemploException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("message", "Ocorreu um erro interno no servidor");

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}