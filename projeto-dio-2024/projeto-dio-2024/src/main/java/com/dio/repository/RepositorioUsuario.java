
package com.dio.repository;

import com.dio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario,Long>{
    
    //Isso aqui é magia
    boolean existsByContaNumero(String accountNumber);
}
