package com.shpaisman.usuario.controller;

import com.shpaisman.usuario.model.UsuarioDTO;
import com.shpaisman.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/{id}")
    public Mono<UsuarioDTO> buscarUsuarios(@PathVariable Integer id){
        return usuarioService.listarUsuarios(id);
    }
    @PostMapping("/novo")
    public Mono<UsuarioDTO> adicionarUsuario(@RequestBody UsuarioDTO usuario){
        return usuarioService.adicionarUsuario(usuario);
    }
    @GetMapping
    public Flux<UsuarioDTO> listarTodosUsuarios(){
        return usuarioService.listarTodosUsuarios();
    }
    @PutMapping("/{id}")
    public Mono<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO usuario, @PathVariable Integer id){
        return usuarioService.updateUsuario(usuario, id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUsuario(@PathVariable Integer id){
        return usuarioService.deleteUsuario(id);
    }
}
