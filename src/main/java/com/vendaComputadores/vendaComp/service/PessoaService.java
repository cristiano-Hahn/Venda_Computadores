/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.service;

import com.vendaComputadores.vendaComp.model.Pessoa;
import com.vendaComputadores.vendaComp.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauricio
 */
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa findOne(Long id) {
        return repository.getOne(id);
    }

    public Pessoa save(Pessoa post) {
        return repository.saveAndFlush(post);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
