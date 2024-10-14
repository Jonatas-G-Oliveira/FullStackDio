/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dio.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
}
