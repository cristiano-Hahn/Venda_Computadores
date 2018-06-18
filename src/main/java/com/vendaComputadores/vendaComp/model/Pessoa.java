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
 * @author mauricio
 */
@Entity(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    private Long id;

    @Column(length = 60)
    private String nome;

    @Column(length = 60)
    private String endereco;

    @Column(length = 60)
    private String bairro;

    @Column()
    private Integer num_bairro;

    @Column(length = 20)
    private String cpf_cnpj;

    @Column(length = 01)
    private String tipo_pesssoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNum_bairro() {
        return num_bairro;
    }

    public void setNum_bairro(Integer num_bairro) {
        this.num_bairro = num_bairro;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getTipo_pesssoa() {
        return tipo_pesssoa;
    }

    public void setTipo_pesssoa(String tipo_pesssoa) {
        this.tipo_pesssoa = tipo_pesssoa;
    }

}
