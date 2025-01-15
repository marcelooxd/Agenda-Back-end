package com.desafio.agenda.dto;

import com.desafio.agenda.entity.Usuario;
import org.springframework.beans.BeanUtils;

public class UsuarioCreateRequest {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Long getId() {  return id; }

    public String getSenha() {  return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNome() {  return nome;  }
    public void setNome(String nome) { this.nome = nome; }

    public UsuarioCreateRequest() {}

    public UsuarioCreateRequest(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }
}
