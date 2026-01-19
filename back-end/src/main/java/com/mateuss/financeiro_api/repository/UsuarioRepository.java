package com.mateuss.financeiro_api.repository;

import com.mateuss.financeiro_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    @Query("select u from Usuario u join fetch u.roles where u.username = :username")
//    Usuario findByUsername(@Param("username") String username);

//    UsuarioDTOResponse findById(Long id);
//    Optional<T> findById(ID id);


    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

//    Usuario findById(Long id);
}
