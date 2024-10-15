package com.dio.service;


import com.dio.model.Usuario;
import com.dio.repository.RepositorioUsuario;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

//Implementação dos serviços expostos pela interface
@Service
public class ServicoUsuarioImpl implements ServicoUsuario {
    
    //Ele vai injetar o repositorio no momento da criação
    private final RepositorioUsuario repositorioUsuario;
    public ServicoUsuarioImpl(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }
    
    @Override
    public Usuario findById(Long id){
        //Esse metodo retorna um opcional
        return repositorioUsuario.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario create(Usuario userToCreate){
        if(repositorioUsuario.existsByContaNumero(userToCreate.getConta().getNumero())){
            throw new IllegalArgumentException("Esse número de conta já existe");
            
        }
        return repositorioUsuario.save(userToCreate);
    }
}
