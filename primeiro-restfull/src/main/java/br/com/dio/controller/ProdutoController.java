
package br.com.dio.controller;

import br.com.dio.entity.Produto;
import br.com.dio.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produto")//Definindo que tudo tem que comecar com produto
public class ProdutoController {
    @Autowired
    private ProdutoService servico;//Criando um controlador para o servico
    
    //localhost:8080/produto/save
    //@RequestMapping(method = RequestMethod.GET, value = "/save")
    //Enviando dados para salvar
    @PostMapping(value = "save")                  //Aqui nós definimos o modo que vai ser passado a requisição
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) throws Exception{
        
        produto = servico.save(produto);
        
        return  ResponseEntity.ok().body(produto);
    }
    
    @GetMapping(value = "/{id}")//Vai vir io identificador do produto
                                  //PathVariable é uma variavel que voce passa atrave´s      do caminho do site
    public ResponseEntity<Produto> pegarProduto(@PathVariable Long id){
        
        Produto produto = servico.findById(id);
        
        return ResponseEntity.ok().body(produto);
    }
    
    @GetMapping(value ="/all")
    public ResponseEntity<List<Produto>> pegarTodosProdutos(){
        
        List<Produto> lista = servico.findAll();
        
        return ResponseEntity.ok().body(lista);
    }
}
