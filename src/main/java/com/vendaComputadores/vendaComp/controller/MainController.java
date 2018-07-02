/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.controller;

import com.vendaComputadores.vendaComp.model.UsuarioDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author crist
 */
@Controller
public class MainController {
    
     @GetMapping("/")
    public ModelAndView menu(){
        ModelAndView mv = new ModelAndView("/login");
        
        mv.addObject("dto", new UsuarioDto());
        
        return mv;
    }
    
}
