package com.desafio.agenda.dto;

import com.desafio.agenda.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponse {

    private Long id;
    private String login;
    private String nome;
    private String email;
    private String senha;
    private List<ContatoResponse> contatos;

    public Long getId() { return id;}

    public String getNome() { return nome;}
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email;}
    public void setEmail(String email) {  this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getLogin() { return login;  }
    public void setLogin(String login) { this.login = login; }

    public UsuarioResponse() {}

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.contatos = usuario.getContatos().stream().map(ContatoResponse::new).collect(Collectors.toList());
    }

}
