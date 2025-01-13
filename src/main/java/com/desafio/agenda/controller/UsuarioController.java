package com.desafio.agenda.controller;

import com.desafio.agenda.dto.LoginResponse;
import com.desafio.agenda.dto.UsuarioCreateRequest;
import com.desafio.agenda.dto.UsuarioResponse;
import com.desafio.agenda.entity.Usuario;
import com.desafio.agenda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@RequestBody LoginResponse login) {
        try {
            Usuario usuario = usuarioService.login(login.getLogin(), login.getSenha());
            if (usuario.getId() != null) {
                UsuarioResponse usuarioRetorno = new UsuarioResponse(usuario);
                return ResponseEntity.ok(usuarioRetorno);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.getUsuarioById(id);
            if (usuario.getId() != null) {
                UsuarioResponse usuarioDTO = new UsuarioResponse(usuario);
                return ResponseEntity.ok(usuarioDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUsuario(@RequestBody UsuarioCreateRequest usuarioRequest) {
        try {
            String retorno = usuarioService.save(usuarioRequest);
            return new ResponseEntity<>(retorno, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> getUsuarioById(@PathVariable Long id, @RequestBody UsuarioCreateRequest usuarioRequest) {
       try {
           String retorno = usuarioService.updateUsuario(id, usuarioRequest);
           return new ResponseEntity<>(retorno, HttpStatus.CREATED);
       }  catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuarioById(@PathVariable Long id) {
        try {
            String mensagem = usuarioService.deleteUsuario(id);
            return ResponseEntity.ok(mensagem);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

