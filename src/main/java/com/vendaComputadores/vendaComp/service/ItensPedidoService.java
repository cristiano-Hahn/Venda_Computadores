/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.service;

import com.vendaComputadores.vendaComp.model.ItensPedido;
import com.vendaComputadores.vendaComp.repository.ItensPedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crist
 */
@Service
public class ItensPedidoService {
    @Autowired
    private ItensPedidoRepository repository;
    
     public List<ItensPedido> findAll(){
        return repository.findAll();
    }
    
    public ItensPedido getOne(Long id){
        return repository.getOne(id);
    }
    
    public ItensPedido save(ItensPedido item){
        return repository.saveAndFlush(item);
    }
}
