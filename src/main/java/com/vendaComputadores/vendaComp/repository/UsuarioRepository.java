/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.repository;

import com.vendaComputadores.vendaComp.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author mauricio
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    @Query("select u from usuario u where u.login = ?1 and u.senha = ?2")
    List<Usuario> buscarUsuario(String login, String senha);
    
}
