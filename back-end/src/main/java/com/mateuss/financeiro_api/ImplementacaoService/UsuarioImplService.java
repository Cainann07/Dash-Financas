package com.mateuss.financeiro_api.ImplementacaoService;


import com.mateuss.financeiro_api.dto.UsuarioDTORequest;
import com.mateuss.financeiro_api.dto.UsuarioDTOResponse;
import com.mateuss.financeiro_api.model.Usuario;
import com.mateuss.financeiro_api.repository.UsuarioRepository;
import com.mateuss.financeiro_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioImplService implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public void adicionarUsuario(UsuarioDTORequest usuarioDTORequest) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(usuarioDTORequest.getEmail());
        novoUsuario.setNome(usuarioDTORequest.getNome());
        novoUsuario.setSobrenome(usuarioDTORequest.getSobrenome());
        novoUsuario.setSenha(usuarioDTORequest.getSenha());
        usuarioRepository.save(novoUsuario);
    }

    @Override
    public UsuarioDTOResponse lerUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            UsuarioDTOResponse usuarioDTOResponse = new UsuarioDTOResponse();
            usuarioDTOResponse.setEmail(usuario.get().getEmail());
            usuarioDTOResponse.setNome(usuario.get().getNome());
            usuarioDTOResponse.setSobrenome(usuario.get().getSobrenome());
            return usuarioDTOResponse;
        }
        return null;
    }

    @Override
    public UsuarioDTOResponse atualizarUsuario(UsuarioDTORequest usuarioDTORequest) {
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuarioDTORequest.getEmail());
        if (usuarioExistente != null) {
            UsuarioDTOResponse usuario = new UsuarioDTOResponse();
            usuarioExistente.setEmail(usuarioDTORequest.getEmail());
            usuarioExistente.setNome(usuarioDTORequest.getNome());
            usuarioExistente.setSobrenome(usuarioDTORequest.getSobrenome());
            usuarioExistente.setSenha(usuarioDTORequest.getSenha());
            usuarioRepository.save(usuarioExistente);

            usuario.setSobrenome(usuarioDTORequest.getSobrenome());
            usuario.setNome(usuarioDTORequest.getNome());
            usuario.setEmail(usuarioDTORequest.getEmail());
            return usuario;
        }
        return null;
    }

    @Override
    public UsuarioDTOResponse deletarUsuario(Long id) {
        UsuarioDTOResponse usuario = lerUsuario(id);
        usuarioRepository.deleteById(id);
        return usuario;
    }
}
