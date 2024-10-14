/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dio.controller;

import br.com.dio.exception.ProductNullException;
import br.com.dio.exception.ProductPriceException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Essa classe controla os erros
@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {
    //Esse controller funciona que nem o controller original,só que ao invéns de passar
    //um endpoint nós vamos passar um erro
    
    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> capturaErroNull(){
        //Esse map é pra criar ma mensagem de erro.
        Map<String, Object> body = new HashMap<>();
        body.put("message","Verifique os campos do produto");
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    
    
    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> capturaErroPreco(){
        
        Map<String,Object> body = new HashMap<>();
        body.put("message","Verifique o preco do produto ");
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
