/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.service;

import com.vendaComputadores.vendaComp.model.ItensPedido;
import com.vendaComputadores.vendaComp.model.Pedido;
import com.vendaComputadores.vendaComp.model.Produto;
import com.vendaComputadores.vendaComp.repository.ItensPedidoRepository;
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
    
    @Autowired
    private ItensPedidoRepository itensRepository;
    
    @Autowired
    private ProdutoService produtoService;
    
    
    
    
    public List<Pedido> findAll(){
        return repository.findAll();
    }
    
    public Pedido getOne(Long id){
        return repository.getOne(id);
    }
    
    public ItensPedido getItem(Long idItem){
        return itensRepository.getOne(idItem);
    }
    
    public Pedido save(Pedido pedido){
        return repository.saveAndFlush(pedido);
    }
    
    public void delete(Pedido pedido){
        repository.delete(pedido);
    }
    
    public Pedido calcTotalPedido(Pedido pedido){
        Double total ;
        total = 0.0;
        
        for (ItensPedido item : pedido.getItensPedido()) {
            
            item.setTotal(item.getProduto().getValorUnitario() * item.getQuantidade());
            total = total + item.getTotal();
            
            produtoService.diminuirEstoque(item.getProduto(), item.getQuantidade());
        }
        
        pedido.setTotal(total);
        
        return pedido;
    }
    
    
}
