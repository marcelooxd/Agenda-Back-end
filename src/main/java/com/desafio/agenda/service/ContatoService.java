package com.desafio.agenda.service;

import com.desafio.agenda.dto.ContatoCreateRequest;
import com.desafio.agenda.dto.ContatoResponse;
import com.desafio.agenda.entity.Contato;
import com.desafio.agenda.entity.ETipoPessoa;
import com.desafio.agenda.entity.Endereco;
import com.desafio.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EnderecoService enderecoService;

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public Contato validarContato(ContatoCreateRequest contato) {
        if (contatoRepository.findContatoByCpfCnpj(contato.getCpfCnpj()).isPresent()) {
            if (contato.getTipoPessoa().equals(ETipoPessoa.FISICA)) {
                throw new RuntimeException("CPF já cadastrado.");
            } else {
                throw new RuntimeException("CNPJ já cadastrado.");
            }
        }
        if (contato.getPrimeiroNome() == null) {
            throw new RuntimeException("Nome não pode estar vazio.");
        }
        if (contato.getCpfCnpj() == null) {
            throw new RuntimeException("CPF/CPNJ não pode ser nulo.");
        }
        if (contato.getSobrenome() == null) {
            throw new RuntimeException("Sobrenome não pode ser nulo.");
        }
        if (contato.getDataAniversario() == null) {
            throw new RuntimeException("A data de aniversário não pode estar vazia.");
        }
        if (contato.getTelefone() == null) {
            throw new RuntimeException("O telefone não pode ser nulo.");
        }

        Contato contatoValidado = new Contato();
        contatoValidado.setPrimeiroNome(contato.getPrimeiroNome());
        contatoValidado.setSobrenome(contato.getSobrenome());
        contatoValidado.setCpfCnpj(contato.getCpfCnpj());
        contatoValidado.setEmail(contato.getEmail());
        contatoValidado.setDataAniversario(contato.getDataAniversario());
        contatoValidado.setTelefone(contato.getTelefone());
        contatoValidado.setProfissao(contato.getProfissao());
        contatoValidado.setTipoPessoa(contato.getTipoPessoa());
        contatoValidado.setGenero(contato.getGenero());
        contatoValidado.setEndereco(enderecoService.saveEndereco(contato.getEndereco()));
        contatoValidado.setUsuario(usuarioService.getUsuarioById(contato.getUsuario()));

        return contatoValidado;
    }

    public List<Contato> getAllContatos(Long idUsuario) {
        return contatoRepository.findAllContatos(idUsuario);
    }

    public Contato getContatoById(Long id) {
        return contatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereco não encontrado."));
    }

    public Page<Contato> getContatosPaginados(String palavraChave, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (palavraChave != null && !palavraChave.isEmpty()) {
            return contatoRepository.findContatosPaginadosFiltrados(palavraChave, pageable);
        } else {
            return contatoRepository.findAllContatosPaginados(pageable);
        }
    }

    public String save(Contato contatoNovo) {
        try {
            contatoRepository.save(contatoNovo);
            return "Contato cadastrado com sucesso!";
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String updateContato(Long id, ContatoCreateRequest contato) {
        try {
            Contato contatoAtualizado = getContatoById(id);
            contatoAtualizado = validarContato(contato);
            contatoRepository.save(contatoAtualizado);
            return "Usuário atualizado com sucesso!";
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String deleteContato(Long id) throws Exception {
        try {
            if (contatoRepository.findById(id).isEmpty()) {
                throw new RuntimeException("Contato não encontrado.");
            }
            contatoRepository.deleteById(id);
            return "Usuário deletado com sucesso!";
        } catch (Exception e) {;
            throw new Exception(e.getMessage());
        }
    }
    

}
