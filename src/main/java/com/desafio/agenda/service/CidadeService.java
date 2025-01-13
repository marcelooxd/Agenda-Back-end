package com.desafio.agenda.service;

import com.desafio.agenda.entity.Cidade;
import com.desafio.agenda.entity.EEstado;
import com.desafio.agenda.entity.Usuario;
import com.desafio.agenda.repository.CidadeRepository;
import com.desafio.agenda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade getCidadeById(Long id) {
        return cidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Cidade não encontrada."));
    }

    public Cidade getCidadeByNomeCidadeEstado(String cidade, EEstado estado) {
        return cidadeRepository.findCidadeByNomeCidadeEstado(cidade, estado);
    }

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

}
