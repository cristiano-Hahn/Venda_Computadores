/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.model;

import java.io.Serializable;
import java.util.Date;
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
@Entity(name = "pedido")
public class Pedido implements Serializable{
    
    @Id
    @SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
    private Long id;
    
    
    @ManyToOne
    @JoinColumn(name = "idpessoa", referencedColumnName = "id", 
            foreignKey = @ForeignKey(name = "fk_produto_pessoa"))
    private Pessoa pessoa;
    
    
    @ManyToOne
    @JoinColumn(name = "idproduto", referencedColumnName = "id", 
            foreignKey = @ForeignKey(name = "fk_produto_estado"))
    private Produto produto;
    
    @Column
    private Integer quantidade;
    
    @Column
    private Double valorUnitario;
    
    @Column
    private Date dataPedido;
    
    @Column
    private Double total;

    public Long getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
