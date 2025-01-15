package com.desafio.agenda.repository;

import com.desafio.agenda.dto.ContatoCreateRequest;
import com.desafio.agenda.entity.Contato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Override
    List<Contato> findAll();

    @Query(" SELECT ct FROM Contato ct " +
            " JOIN FETCH ct.endereco en " +
            " JOIN FETCH en.cidade " +
            " JOIN FETCH ct.usuario usua " +
            " WHERE ct.usuario.id = :idUsuario ")
    List<Contato> findAllContatos(@Param("idUsuario") Long idUsuario);

    @Query("SELECT ct FROM Contato ct WHERE ct.usuario.id = :idUsuario")
    List<Contato> findByUsuario(@Param("idUsuario") Long idUsuario);

    @Query(" SELECT ct FROM Contato ct " +
            " JOIN FETCH ct.endereco en " +
            " JOIN FETCH en.cidade " +
            " JOIN FETCH ct.usuario usua " +
            " WHERE ct.id = :id ")
    Contato findContatoById(@Param("id") Long id);

    @Query("SELECT ct FROM Contato ct where ct.cpfCnpj = :cpfCnpj ")
    Optional<Contato> findContatoByCpfCnpj(@Param("cpfCnpj") String cpfCnpj);

    @Query("SELECT ct FROM Contato ct " +
            " JOIN FETCH ct.endereco en " +
            " JOIN FETCH en.cidade " +
            " JOIN FETCH ct.usuario usua " +
            "WHERE ct.id = :id ")
    Contato findContatoCompletoById(@Param("id")Long id);

    @Query(value =
            " SELECT ct FROM Contato ct " +
            " JOIN FETCH ct.usuario usua " +
            " JOIN FETCH ct.endereco ende " +
            " JOIN FETCH ende.cidade cid " +
            " WHERE ct.usuario.id = :idUsuario " +
            " AND (:palavraChave IS NOT NULL AND :palavraChave <> '' ) AND :palavraChave = ct.primeiroNome ",
    countQuery =
            " SELECT count(ct) FROM Contato ct " +
            " JOIN ct.usuario usua "  +
            " JOIN ct.endereco ende " +
            " JOIN ende.cidade cid " +
            " WHERE ct.usuario.id = :idUsuario " +
            " AND (:palavraChave IS NOT NULL AND :palavraChave <> '' ) AND :palavraChave = ct.primeiroNome ")
    Page<Contato> findContatosPaginadosFiltrados(@Param("idUsuario") Long idUsuario, @Param("palavraChave") String palavraChave, Pageable pageable);

    @Query(value =
            "SELECT ct FROM Contato ct " +
            " JOIN FETCH ct.usuario usua " +
            " JOIN FETCH ct.endereco ende " +
            " JOIN FETCH ende.cidade cid " +
            " WHERE ct.usuario.id = :idUsuario ",
    countQuery =
            "SELECT count(ct) FROM Contato ct " +
            " JOIN ct.usuario usua "  +
            " JOIN ct.endereco ende " +
            " JOIN ende.cidade cid " +
            " WHERE ct.usuario.id = :idUsuario ")
    Page<Contato> findAllContatosPaginados(@Param("idUsuario") Long idUsuario, Pageable pageable);

    @Modifying
    @Query("UPDATE FROM Contato ct set ct.usuario = :idUsuario WHERE ct.id = :id ")
    void updateUsuario(@Param("id") Long id, @Param("idUsuario") Long idUsuario);

}