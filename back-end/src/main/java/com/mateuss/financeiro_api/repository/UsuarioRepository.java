package com.mateuss.financeiro_api.repository;

import com.mateuss.financeiro_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u join fetch u.roles where u.username = :username")
    Usuario findByUsername(@Param("username") String username);

}
