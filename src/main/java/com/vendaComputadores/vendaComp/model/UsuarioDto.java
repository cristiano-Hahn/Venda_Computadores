/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendaComputadores.vendaComp.model;

import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 *
 * @author CristianoH
 */
@Component
public class UsuarioDto implements Serializable {
    
    private String login;
    
    private String senha;
    
    private Boolean Valido;

    public Boolean getValido() {
        return Valido;
    }

    public void setValido(Boolean Valido) {
        this.Valido = Valido;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
