
package dio.aula.repository;

import dio.aula.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//Preciso implementar a interface do JPA            //Classe,Id
public interface UserRepository extends JpaRepository<Usuario,Integer>{
    
}
