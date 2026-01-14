package com.mateuss.financeiro_api.service;

import com.mateuss.financeiro_api.dto.UsuarioDTORequest;
import com.mateuss.financeiro_api.dto.UsuarioDTOResponse;
import com.mateuss.financeiro_api.model.Usuario;

public interface UsuarioService {

    void adicionarUsuario(UsuarioDTORequest usuarioDTORequest);
    UsuarioDTOResponse lerUsuario(Long id);
    UsuarioDTOResponse atualizarUsuario(UsuarioDTORequest usuarioDTORequest);
    UsuarioDTOResponse deletarUsuario(Long id);
}
