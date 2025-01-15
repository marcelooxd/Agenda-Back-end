package com.desafio.agenda.service;

import com.desafio.agenda.dto.UsuarioCreateRequest;
import com.desafio.agenda.entity.Usuario;
import com.desafio.agenda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario validarUsuario(UsuarioCreateRequest usuario) {
        try {
            if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
                throw new RuntimeException("E-mail já cadastrado.");
            }
            if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
                throw new RuntimeException("Nome não pode estar vazio.");
            }
            if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
                throw new RuntimeException("A senha não pode estar vazia.");
            }
            Usuario usuarioValidado = new Usuario();
            usuarioValidado.setNome(usuario.getNome());
            usuarioValidado.setSenha(usuario.getSenha());
            usuarioValidado.setEmail(usuario.getEmail());

            return usuarioValidado;

        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Não foi possivel salvar o usuário");
        }
    }

    public Usuario login(String login, String senha) {
        try {
            return usuarioRepository.findByLoginSenha(login, senha);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    public Usuario getUsuarioPorId(Long id) {
        return usuarioRepository.findUsuarioById(id);
    }


    public String save(UsuarioCreateRequest usuario) throws Exception {
        try {
            Usuario usuarioNovo = validarUsuario(usuario);
            usuarioRepository.save(usuarioNovo);
            return "Usuário cadastrado com sucesso!";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String updateUsuario(Long id, UsuarioCreateRequest usuario) throws Exception {
        try {
            Usuario usuarioAtualizado = getUsuarioById(id);
            usuarioAtualizado = validarUsuario(usuario);
            usuarioRepository.save(usuarioAtualizado);
            return "Usuário atualizado com sucesso!";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String deleteUsuario(Long id) throws Exception {
        try {
            if (usuarioRepository.findById(id).isEmpty()) {
                throw new RuntimeException("Usuário não encontrado.");
            }
            usuarioRepository.deleteById(id);
            return "Usuário deletado com sucesso!";
        } catch (Exception e) {;
            throw new Exception(e.getMessage());
        }
    }
}
