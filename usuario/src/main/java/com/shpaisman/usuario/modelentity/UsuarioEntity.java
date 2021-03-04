package com.shpaisman.usuario.modelentity;

import com.shpaisman.usuario.model.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("usuario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @Column("id")
    private Integer id;
    @Column("nome")
    private String nome;

    public UsuarioEntity(UsuarioDTO usuario){
        super();
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }
}
