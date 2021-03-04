package com.shpaisman.usuario.controller;

import com.shpaisman.usuario.model.UsuarioDTO;
import com.shpaisman.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
