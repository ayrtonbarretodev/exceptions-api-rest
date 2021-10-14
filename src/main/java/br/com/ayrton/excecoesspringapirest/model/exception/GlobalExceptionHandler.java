package br.com.ayrton.excecoesspringapirest.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        DetalhesErros detalhesErros = new DetalhesErros(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalhesErros, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExceptionHandler(Exception ex, WebRequest request){
        DetalhesErros detalhesErros = new DetalhesErros(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalhesErros, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
