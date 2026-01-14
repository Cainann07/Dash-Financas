package com.mateuss.financeiro_api.repository;

import com.mateuss.financeiro_api.dto.UsuarioDTOResponse;
import com.mateuss.financeiro_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u join fetch u.roles where u.username = :username")
    Usuario findByUsername(@Param("username") String username);

//    UsuarioDTOResponse findById(Long id);
//    Usuario findById(Long id);


    boolean existsByEmail(String email);

    Usuario findByEmail(String email);
}
