package com.dio.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;


@Entity(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    //Indica a cardinalidade e que possuem um relacionamento forte entre si
    @OneToOne(cascade = CascadeType.ALL)
    private Cartao cartao;
    @OneToOne(cascade = CascadeType.ALL)
    private Conta conta;
    
    //Toda vez que ele procura um usuario no banco ele busca a lista que esta junto com ele
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Features> feature;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Extras> extras;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome;  }

    public void setNome(String nome) { this.nome = nome; }

    public Cartao getCartao() { return cartao; }

    public void setCartao(Cartao cartao) { this.cartao = cartao; }

    public Conta getConta() { return conta; }

    public void setConta(Conta conta) { this.conta = conta; }

    public List<Features> getFeature() { return feature; }

    public void setFeature(List<Features> feature) { this.feature = feature; }

    public List<Extras> getExtras() { return extras; }

    public void setExtras(List<Extras> extras) { this.extras = extras; }
  
}
