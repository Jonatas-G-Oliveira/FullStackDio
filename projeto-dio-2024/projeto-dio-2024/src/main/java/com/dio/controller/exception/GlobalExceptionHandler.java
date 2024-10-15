package com.dio.controller.exception;

import java.util.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    //Não sei o que é isso
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException){
        return new ResponseEntity<>(businessException.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleElementException (NoSuchElementException notFoundException ){
        return new ResponseEntity<>("Resource ID Not Found",HttpStatus.NOT_FOUND); 
    }
    
    //Exceções globais
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable noExpectedException){
        String message ="Erro inesperado no servidor,necessario ver os logs";
        logger.error(message,noExpectedException);
        return new ResponseEntity<>("Aconteceu uma excessão inexperada",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
