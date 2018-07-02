/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.controller;

/*
 @author mauricio
 */
import com.vendaComputadores.vendaComp.model.Pessoa;
import com.vendaComputadores.vendaComp.service.PessoaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import static sun.misc.ClassFileTransformer.add;

@Controller()
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping("/cliente")
    public ModelAndView findAll() {
        //O método vai exibir a página produto.html
        ModelAndView mv = new ModelAndView("/pessoa");

        mv.addObject("pessoas", service.findAll());

        return mv;
    }

    @PostMapping("cliente/save")
    public ModelAndView save(@Valid Pessoa pessoa, BindingResult result) {
        if (result.hasErrors()) {
            return add(pessoa);
        }

        service.save(pessoa);

        return findAll();
    }

    @GetMapping("cliente/add")
    private ModelAndView add(Pessoa pessoa) {
        ModelAndView mv = new ModelAndView("/pessoaAdd");
        mv.addObject("pessoa", pessoa);
        return mv;
    }

    @GetMapping("cliente/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(service.findOne(id));
    }

    @GetMapping("cliente/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        service.delete(id);
        return findAll();
    }

}
