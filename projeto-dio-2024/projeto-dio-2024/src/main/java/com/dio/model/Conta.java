package com.dio.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity(name = "tb_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String numero;
    
    private String agencia;
    
    //11 decimais
    @Column(precision = 13, scale = 2)
    private BigDecimal dinheiro;
    @Column(name = "limite_adicional",scale = 13, precision = 2)
    private BigDecimal limite;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
    
    public String getNumero(){ return this.numero; }
    
    public void setNumero(String numero) { this.numero = numero;}
    
    public String getAgencia() {return this.agencia ;}
    
    public void setAgencia(String agencia){ this.agencia = agencia;}
    
    public BigDecimal getDinheiro() { return this.dinheiro; }
    
    public void setDinheiro(BigDecimal dinheiro ){ this.dinheiro = dinheiro; }

    public BigDecimal getLimite() { return limite; }

    public void setLimite(BigDecimal limite) { this.limite = limite; }
    
    
    
    
    

   
    
    
}
