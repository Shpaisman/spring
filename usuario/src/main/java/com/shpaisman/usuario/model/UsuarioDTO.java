package com.shpaisman.usuario.model;

import com.shpaisman.usuario.modelentity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String nome;

    public static Mono<UsuarioDTO> fromEntity(UsuarioEntity usuarioEntity){
        return Mono.just(usuarioEntity)
                .flatMap(x->{
                    UsuarioDTO usuario = new UsuarioDTO();
                    usuario.setId(x.getId());
                    usuario.setNome(x.getNome());
                    return Mono.just(usuario);
                });
    }
}
