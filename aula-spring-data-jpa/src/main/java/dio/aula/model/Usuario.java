package dio.aula.model;

import jakarta.persistence.Column;//Define como cada campo
import jakarta.persistence.Entity;//Define que a nossa classe é uma entidade
import jakarta.persistence.GeneratedValue;//Atribui valores automáticos para o ID
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;//Indica uma chave primária na aplicação
import jakarta.persistence.Table;


//Basicamente estamos criando o MySQL dentro do java
@Entity//Transfomando classe em uma entidadde
@Table(name = "tab_user")//Muda o nome da tabela
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")//o ID vai se chamar User_id
    private Integer id;
    @Column(length = 50,nullable = false)
    private String nome;
    @Column(length = 20,nullable = false)
    private String username;
    @Column(length = 100,nullable = false)
    private String password;
    
    public Integer getId(){
        return id;
    }
    public void setId (Integer id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
