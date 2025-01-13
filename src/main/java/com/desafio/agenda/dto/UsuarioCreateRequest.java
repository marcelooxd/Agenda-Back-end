package com.desafio.agenda.dto;

import com.desafio.agenda.entity.Usuario;
import org.springframework.beans.BeanUtils;

public class UsuarioCreateRequest {

    private Long id;
    private String login;
    private String nome;
    private String email;
    private String senha;

    public Long getId() {  return id; }

    public String getLogin() {  return login;  }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() {  return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNome() {  return nome;  }
    public void setNome(String nome) { this.nome = nome; }

    public UsuarioCreateRequest() {}

    public UsuarioCreateRequest(Usuario usuario) {
        BeanUtils.copyProperties(usuario, this);
    }
}
