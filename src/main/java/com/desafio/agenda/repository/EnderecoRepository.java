package com.desafio.agenda.repository;

import com.desafio.agenda.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT ende FROM Endereco ende " +
            "JOIN FETCH ende.cidade cid " +
            "WHERE ende.id = :id ")
    Endereco getEnderecoById(@Param("id") Long id);

}