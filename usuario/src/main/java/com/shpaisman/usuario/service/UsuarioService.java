package com.shpaisman.usuario.service;

import com.shpaisman.usuario.model.UsuarioDTO;
import com.shpaisman.usuario.modelentity.UsuarioEntity;
import com.shpaisman.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Mono<UsuarioDTO> getUsuario(Integer id){
        return usuarioRepository.findById(id)
                .flatMap(UsuarioDTO::fromEntity);
    }

    public Mono<UsuarioDTO> postUsuario(UsuarioDTO usuario){
        return Mono.just(new UsuarioEntity(usuario))
                .flatMap(x->{
                    UsuarioEntity entity = (UsuarioEntity) x;
                    return usuarioRepository.save(entity);
                })
                .flatMap(UsuarioDTO::fromEntity);
    }

    public Flux<UsuarioDTO> getUsuarios(){
        return usuarioRepository.findAll()
                .flatMap(UsuarioDTO::fromEntity);
    }
    public Mono<UsuarioDTO> updateUsuario(UsuarioDTO usuario, Integer id){
        return usuarioRepository.findById(id)
                .flatMap(x->{
                    x.setNome(usuario.getNome());
                    return Mono.just(x);
                })
                .flatMap(x->
                    usuarioRepository.save(x)
                )
                .flatMap(UsuarioDTO::fromEntity);
    }
    public Mono<Void> deleteUsuario(Integer id){
        return usuarioRepository.findById(id)
                .flatMap(x->
                        usuarioRepository.delete(x));
    }
}
