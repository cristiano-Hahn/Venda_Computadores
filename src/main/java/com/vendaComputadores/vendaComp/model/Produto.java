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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
    
    
    
}
