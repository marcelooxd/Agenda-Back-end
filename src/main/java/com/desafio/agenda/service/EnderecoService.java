package com.desafio.agenda.service;

import com.desafio.agenda.dto.EnderecoCreateRequest;
import com.desafio.agenda.entity.Cidade;
import com.desafio.agenda.entity.Endereco;
import com.desafio.agenda.entity.Usuario;
import com.desafio.agenda.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private CidadeService cidadeService;

    public Endereco validarEndereco(EnderecoCreateRequest endereco) {
        if (endereco.getRua() == null) {
            throw new RuntimeException("Rua não pode ser nulo.");
        }
        if (endereco.getBairro() == null) {
            throw new RuntimeException("Bairro não pode ser nulo.");
        }
        if (endereco.getCep() == null) {
            throw new RuntimeException("CEP não pode ser nulo.");
        }
        if (endereco.getNumero() == null) {
            throw new RuntimeException("Numero não pode ser nulo.");
        }

        Endereco enderecoNovo = new Endereco();
        if (endereco.getCidade() != null) {
            Cidade cidade = cidadeService.getCidadeByNomeCidadeEstado(endereco.getCidade().getCidade(),
                    endereco.getCidade().getEstado());
            if (cidade != null) {
                enderecoNovo.setCidade(cidade);
            } else {
                enderecoNovo.setCidade(cidadeService.save(new Cidade(endereco.getCidade())));
            }
        }

        enderecoNovo.setRua(endereco.getRua());
        enderecoNovo.setBairro(endereco.getBairro());
        enderecoNovo.setCep(endereco.getCep());
        enderecoNovo.setNumero(endereco.getNumero());
        enderecoNovo.setComplemento(endereco.getComplemento());
        enderecoNovo.setLatitude(endereco.getLatitude());
        enderecoNovo.setLongitude(endereco.getLongitude());

        return enderecoNovo;
    }

    public Endereco getEnderecoById(Long id) {
        try {
            return enderecoRepository.getEnderecoById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Endereco não encontrado.");
        }
    }

    public Endereco saveEndereco(EnderecoCreateRequest endereco) {
        Endereco enderecoNovo = validarEndereco(endereco);
        return enderecoRepository.save(enderecoNovo);
    }

    public void updateEndereco(Long id, EnderecoCreateRequest endereco) {
        Endereco enderecoNovo = getEnderecoById(id);
        enderecoNovo = validarEndereco(endereco);
        enderecoRepository.save(enderecoNovo);
    }

    public void deleteEndereco(Long id) {
       if (!enderecoRepository.existsById(id)) {
            throw new RuntimeException("Endereco não encontrado.");
        }
        enderecoRepository.deleteById(id);
    }
}
