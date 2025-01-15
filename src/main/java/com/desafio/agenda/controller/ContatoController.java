package com.desafio.agenda.controller;

import com.desafio.agenda.dto.ContatoCreateRequest;
import com.desafio.agenda.dto.ContatoResponse;
import com.desafio.agenda.dto.UsuarioCreateRequest;
import com.desafio.agenda.dto.UsuarioResponse;
import com.desafio.agenda.entity.Contato;
import com.desafio.agenda.entity.Usuario;
import com.desafio.agenda.service.ContatoService;
import com.desafio.agenda.service.EnderecoService;
import com.desafio.agenda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ContatoResponse>> getAllContatos(@PathVariable Long idUsuario) {
        try {
            List<Contato> contatos = contatoService.getAllContatos(idUsuario);
            if (CollectionUtils.isEmpty(contatos)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(contatos.stream().map(
                        ContatoResponse::new).collect(Collectors.toList()), HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponse> getContatoById(@PathVariable Long id) {
        try {
            Contato contato = contatoService.getContatoById(id);
            if (contato.getId() != null) {
                ContatoResponse contatoDTO = new ContatoResponse(contato);
                return ResponseEntity.ok(contatoDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contatosPaginados")
    public Page<ContatoResponse> getContatosPaginados(
            @RequestParam(value = "idUsuario", required = false) Long idUsuario,
            @RequestParam(value = "palavraChave", required = false, defaultValue = "") String palavraChave,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        try {
            Page<Contato> contatos = contatoService.getContatosPaginados(idUsuario, palavraChave, page, size);
            return contatos.map(ContatoResponse::new);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveContato(@RequestBody ContatoCreateRequest contato) {
        try {
            Contato contatoNovo = contatoService.validarContato(contato);
            if (contatoNovo.getEndereco().getId() != null
                    && contatoNovo.getUsuario().getId() != null) {
                String retorno = contatoService.save(contatoNovo);
                return new ResponseEntity<>(retorno, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateContato(@PathVariable Long id, @RequestBody ContatoCreateRequest contato) {
        try {
            String retorno = contatoService.updateContato(id, contato);
            return new ResponseEntity<>(retorno, HttpStatus.CREATED);
        }  catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUsuarioById(@PathVariable Long id) {
        try {
            String mensagem = contatoService.deleteContato(id);
            return ResponseEntity.ok(mensagem);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

