/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.service;

import com.vendaComputadores.vendaComp.model.Pedido;
import com.vendaComputadores.vendaComp.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CristianoH
 */
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;
    
    
    public List<Pedido> findAll(){
        return repository.findAll();
    }
    
    public Pedido getOne(Long id){
        return repository.getOne(id);
    }
    
    public Pedido save(Pedido pedido){
        return repository.saveAndFlush(pedido);
    }
    
}
