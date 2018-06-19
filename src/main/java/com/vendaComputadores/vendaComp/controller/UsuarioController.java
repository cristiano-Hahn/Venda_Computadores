/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.controller;

/**
 *
 * @author mauricio
 */
import com.vendaComputadores.vendaComp.model.Produto;
import com.vendaComputadores.vendaComp.model.Usuario;
import com.vendaComputadores.vendaComp.service.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/usuario");

        mv.addObject("usuarios", service.findAll());

        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return add(usuario);
        }

        service.save(usuario);

        return findAll();
    }

    @GetMapping("/add")
    private ModelAndView add(Usuario usuario) {
        ModelAndView mv = new ModelAndView("/usuarioAdd");
        mv.addObject("usuario", usuario);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(service.findOne(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        service.delete(id);
        return findAll();
    }

}
