/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.controller;

import com.vendaComputadores.vendaComp.model.Pedido;
import com.vendaComputadores.vendaComp.service.PedidoService;
import com.vendaComputadores.vendaComp.service.PessoaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    private PessoaService pessoaService;
    
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
    
    
    
    
}
