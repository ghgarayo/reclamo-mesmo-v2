package br.com.senior.reclamomesmo.domain.pessoa;

import br.com.senior.reclamomesmo.domain.endereco.Endereco;
import br.com.senior.reclamomesmo.domain.usuario.Usuario;
import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.UUID;

@MappedSuperclass
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public abstract class Pessoa {

    @Id
    private String id;
    private String telefone;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Embedded
    private Endereco endereco;

    @Column(name = "is_active")
    private boolean isActive;

    public Pessoa(String telefone, Usuario usuario, DTOEndereco endereco) {
        this.id = UUID.randomUUID().toString();
        this.telefone = telefone;
        this.usuario =  usuario;
        this.endereco = new Endereco(endereco);
        this.isActive = true;
    }

    public void inativar() {
        this.isActive = false;
    }

    public void atualizar(String telefone, DTOEndereco endereco){
        if(telefone != null){
            this.telefone = telefone;
        }
        if(endereco != null){
            this.endereco = new Endereco(endereco);
        }
    }

}
