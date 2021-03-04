package com.shpaisman.usuario.service;

import com.shpaisman.usuario.model.UsuarioDTO;
import com.shpaisman.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Mono<UsuarioDTO> listarUsuarios(Integer id){
        return usuarioRepository.findById(id)
                .flatMap(UsuarioDTO::fromEntity);
    }
}
