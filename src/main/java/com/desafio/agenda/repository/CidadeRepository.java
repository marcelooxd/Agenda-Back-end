package com.desafio.agenda.repository;

import com.desafio.agenda.entity.Cidade;

import com.desafio.agenda.entity.EEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("SELECT cid FROM Cidade cid WHERE cid.id = :id ")
    Cidade findCidadeById(@Param("id") Long id);

    @Query("SELECT cid FROM Cidade cid WHERE cid.cidade = :cidade AND cid.estado = :estado")
    Cidade findCidadeByNomeCidadeEstado(@Param("cidade") String cidade,
                                        @Param("estado") EEstado estado);
}