/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.controller;

import com.vendaComputadores.vendaComp.model.UsuarioDto;
import com.vendaComputadores.vendaComp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author crist
 */
@Controller
public class LoginController {
    
    @Autowired
    UsuarioService service;
    
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute UsuarioDto user){
        ModelAndView mv; 
        if(service.validouUsuario(user.getLogin(), user.getSenha())){
            mv = new ModelAndView("/produto");        
        } else {
            mv = new ModelAndView("/login");        
            user.setValido(Boolean.FALSE);
            mv.addObject("dto", user);
        }
    

    
    
    
    
    
    
    
    return mv;    
    } 
}
