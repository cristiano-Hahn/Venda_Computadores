/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.controller;

import com.vendaComputadores.vendaComp.model.ItensPedido;
import com.vendaComputadores.vendaComp.model.Pedido;
import com.vendaComputadores.vendaComp.service.ItensPedidoService;
import com.vendaComputadores.vendaComp.service.PedidoService;
import com.vendaComputadores.vendaComp.service.PessoaService;
import com.vendaComputadores.vendaComp.service.ProdutoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author CristianoH
 */
@Controller
public class PedidoController {
    
    @Autowired
    private PedidoService service;
    
    @Autowired
    private ItensPedidoService itensPedidoService;
    
    @Autowired
    private PessoaService pessoaService;
    
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping("/pedido")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("/pedido");
        
        mv.addObject("pedidos", service.findAll());
        
        return mv;
    }
    
    @GetMapping("pedido/add")
    public ModelAndView add(Pedido pedido){
        ModelAndView mv = new ModelAndView("/pedidoAdd");
        mv.addObject("pedido", pedido);
        mv.addObject("pessoas", pessoaService.findAll());
        return mv;
    }
    
    @PostMapping("pedido/save")
    public ModelAndView save(@Valid Pedido pedido, BindingResult result){
        if (result.hasErrors()){
            return add(pedido);
        }
        
        service.save(pedido);
        
        return findAll();
    }
    
    @GetMapping("pedido/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        Pedido pedido;
        
        pedido = service.getOne(id);
        
        ModelAndView mv = new ModelAndView("/pedidoAdd");
        mv.addObject("pedido", pedido);
        mv.addObject("item", new ItensPedido());
        mv.addObject("produtos", produtoService.findAll());
        
        
        return mv;
        //return add(service.getOne(id));
    }
    
    @GetMapping("pedido/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        
        service.delete(service.getOne(id));
        return findAll();
    }
    
    @PostMapping("pedido/{id}/itens/add")
    public String saveItens(@PathVariable("id") Long id, @Valid  ItensPedido itens){
        
        Pedido pedido = service.getOne(id);
        
        pedido.getItensPedido().add(itens);
        
        service.save(pedido);
        
        return "redirect:/pedido/edit/" + id.toString() + "#detalhe";
    }
    
    @GetMapping("pedido/{idpedido}/itens/delete/{iditem}") 
    public String deleteItem(@PathVariable("idpedido") Long idPedido, @PathVariable("iditem") Long idItem){
        
        Pedido pedido =  service.getOne(idPedido);
               
        pedido.getItensPedido().remove(idItem);
        
        return "redirect:/pedido/edit/" + idPedido.toString() + "#detalhe";
    }
    
    
}
