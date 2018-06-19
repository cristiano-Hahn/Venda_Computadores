/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.service;

import com.vendaComputadores.vendaComp.model.Produto;
import com.vendaComputadores.vendaComp.model.Usuario;
import com.vendaComputadores.vendaComp.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauricio
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findOne(Long id) {
        return repository.getOne(id);
    }

    public Usuario save(Usuario post) {
        return repository.saveAndFlush(post);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
