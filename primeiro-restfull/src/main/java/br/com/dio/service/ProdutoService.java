package br.com.dio.service;

import br.com.dio.exception.ProductPriceException;
import br.com.dio.exception.ProductNullException;
import br.com.dio.entity.Produto;
import br.com.dio.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repositorio;
    
    public Produto save(Produto produto)throws Exception{
        if(produto.getNome() == null) 
            throw new ProductNullException();
        if(produto.getPreco() < 0){
            throw new ProductPriceException();
        }
        return repositorio.save(produto);
    }
    
    public Produto findById(Long id){
        return repositorio.findById(id).orElse(null);
    }
    
    public List<Produto> findAll(){
        return repositorio.findAll();
    }
}
