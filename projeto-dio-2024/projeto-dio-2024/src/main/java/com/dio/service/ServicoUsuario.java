package com.dio.service;

import com.dio.model.Usuario;



//Interface mostra os métodos disponíveis
public interface ServicoUsuario {
    Usuario findById(Long id);

    Usuario create(Usuario userToCreate);
}
