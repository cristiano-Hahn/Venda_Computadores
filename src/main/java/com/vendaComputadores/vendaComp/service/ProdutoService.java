/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.service;

import com.vendaComputadores.vendaComp.model.Produto;
import com.vendaComputadores.vendaComp.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crist
 */
@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;
    
    public List<Produto> findAll() {
        return repository.findAll();
    }
    
    public Produto findOne(Long id) {
	return repository.getOne(id);
    }
	
    public Produto save(Produto post) {
	return repository.saveAndFlush(post);
    }
	
    public void delete(Long id) {
	repository.deleteById(id);
    }    
   
    public void diminuirEstoque(Produto produto, Integer quantidade){
        if (produto.getQuantidadeDisponivel() < quantidade){
            //Realizar aqui uma validação
        }
        produto.setQuantidadeDisponivel(produto.getQuantidadeDisponivel() - quantidade);
        
      //  save(produto);
    }
}
