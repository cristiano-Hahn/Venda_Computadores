/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author crist
 */
@Entity(name = "produto")
public class Produto implements Serializable {
    
    @Id
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    private Long id;
    
    @Column(length = 50)
    private String nome;
    
    @Column
    private Double valorUnitario;
    
    @Column
    private Integer quantidadeDisponivel;
    
}
