package com.desafio.agenda.repository;

import com.desafio.agenda.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u where u.email = :email ")
    Optional<Usuario> findByEmail(@Param("email")String email);

    @Query("SELECT u FROM Usuario u " +
            "LEFT JOIN FETCH u.contatos ct " +
            "WHERE u.email = :email AND u.senha = :senha ")
    Usuario findByLoginSenha(@Param("email") String email, @Param("senha")String senha);

    @Query("select u from Usuario u left join fetch u.contatos where u.id = :id ")
    Usuario findUsuarioById(@Param("id")Long id);

    Usuario save(Usuario usuario);

    Usuario getUsuarioById(Long id);
}