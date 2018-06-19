/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.repository;

import com.vendaComputadores.vendaComp.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crist
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
