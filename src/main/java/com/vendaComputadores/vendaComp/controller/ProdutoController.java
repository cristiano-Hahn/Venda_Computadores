/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.controller;

import com.vendaComputadores.vendaComp.model.Produto;
import com.vendaComputadores.vendaComp.service.ProdutoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import static sun.misc.ClassFileTransformer.add;

/**
 *
 * @author crist
 */
@Controller("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;
    
    
    public ModelAndView findAll(){
        //O método vai exibir a página produto.html
        ModelAndView mv = new ModelAndView("/produto");
        
        mv.addObject("produtos", service.findAll());
        
        return mv;
    }
    
    @PostMapping("/save")
    public ModelAndView save(@Valid Produto produto, BindingResult result){
        if (result.hasErrors()){
            return add(produto);
        }
        
        service.save(produto);
        
        return findAll();
    }
    
    @GetMapping("/add")
    private ModelAndView add(Produto produto) {
        ModelAndView mv = new ModelAndView("/produtoAdd");
	mv.addObject("produto", produto);
	return mv;
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        return add(service.findOne(id));
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {	
        service.delete(id);	
	return findAll();
   }
        
}
