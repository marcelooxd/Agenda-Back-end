package com.desafio.agenda.dto;

import com.desafio.agenda.entity.Usuario;

public class LoginResponse {

    private String login;
    private String senha;

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getLogin() { return login;  }
    public void setLogin(String login) { this.login = login; }

    public LoginResponse() {}

    public LoginResponse(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

}
