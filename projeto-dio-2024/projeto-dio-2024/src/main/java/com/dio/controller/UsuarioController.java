
package com.dio.controller;

import com.dio.model.Usuario;
import com.dio.service.ServicoUsuario;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    
    //Pegando os metodos expostos pela interface
    private final ServicoUsuario servicoUsuario;
    public UsuarioController(ServicoUsuario servicoUsuario){
        this.servicoUsuario = servicoUsuario;
    }
    
    //A parte da URI eu não pesquei
    //PathBariable -> Variaveis simples expostas 
    //RequestBody -> Utilizada para objetos com multiplas caracteristicas
    //É necessário utilizar um responseEntity para os servicos expostos
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario resposta = servicoUsuario.findById(id);
        return ResponseEntity.ok(resposta);
    }
    
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario){
        Usuario resposta = servicoUsuario.create(usuario);
        URI localizacao = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resposta.getId())
                .toUri();
        return ResponseEntity.created(localizacao).body(resposta);
    }
    
}
