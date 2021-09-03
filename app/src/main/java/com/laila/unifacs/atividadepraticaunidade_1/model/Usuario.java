package com.laila.unifacs.atividadepraticaunidade_1.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String usuario, senha;

    public Usuario() {}

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    //region Getters and Setters
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String newUsuario) {
        this.usuario = newUsuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String newSenha) {
        this.senha = newSenha;
    }
    //endregion

}
