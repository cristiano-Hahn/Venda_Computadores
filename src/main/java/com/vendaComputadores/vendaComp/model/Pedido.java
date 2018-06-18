/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
}
