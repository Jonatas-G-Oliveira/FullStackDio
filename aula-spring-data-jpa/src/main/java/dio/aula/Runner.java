/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dio.aula;

import dio.aula.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import dio.aula.repository.UserRepository;

//Tomar cuidado com as plavras reservdas
@Component//Objeto gerenciado pelo Spring framwork
public class Runner implements CommandLineRunner {
    @Autowired
    private UserRepository repositorio;
    @Override
    public void run(String... args) throws Exception {
       Usuario usuario1 = new Usuario();
       //usuario1.setId(1);
       usuario1.setNome("JOnatas");
       usuario1.setUsername("Jhony");
       usuario1.setPassword("123");
       
      System.out.println(usuario1.getId());
      System.out.println(usuario1.getNome());
      System.out.println(usuario1.getUsername());
      System.out.println(usuario1.getPassword());
      
      //Por enquanto isso aqui é volátil
      System.out.println(repositorio.count());
      repositorio.save(usuario1);
      System.out.println(repositorio.count());
      
      for(Usuario u: repositorio.findAll()){
          System.out.println(u.getNome());
      }
    }
    
}
