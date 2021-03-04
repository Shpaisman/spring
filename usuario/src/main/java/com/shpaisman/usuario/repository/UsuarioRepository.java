package com.shpaisman.usuario.repository;

import com.shpaisman.usuario.modelentity.UsuarioEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<UsuarioEntity, Integer> {

}
