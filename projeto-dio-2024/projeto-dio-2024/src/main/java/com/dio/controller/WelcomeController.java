/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(){
        String resposta = "Bem vindo ao meu projeto santander DIO";
        return resposta;
    }
}
