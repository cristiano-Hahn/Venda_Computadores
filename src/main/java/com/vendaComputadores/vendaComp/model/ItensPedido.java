/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author crist
 */
@Entity(name = "itenspedido")
public class ItensPedido implements Serializable{
    
    @Id
    @SequenceGenerator(name = "itenspedido_seq", sequenceName = "itenspedido_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itenspedido_seq")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "idproduto", referencedColumnName = "id", 
    foreignKey = @ForeignKey(name = "fk_produto_estado"))
    private Produto produto;
    
    @Column
    private Double valorUnitario;
    
    @Column
    private Integer quantidade;
    
    @Column
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    
    
}
