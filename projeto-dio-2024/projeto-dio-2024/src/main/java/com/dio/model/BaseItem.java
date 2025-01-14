package com.dio.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


//Estamos criando essa classe com base no padrão de projeto DOnt Repeat Yourself,ja que eu tinha duas classes
//com implementação semelhante
//ste
@MappedSuperclass
public abstract class BaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icone;
    private String descricao;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getIcone() { return icone; }

    public void setIcone(String icone) { this.icone = icone; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
