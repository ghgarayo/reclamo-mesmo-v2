package br.com.senior.reclamomesmo.domain.pessoa;

import br.com.senior.reclamomesmo.domain.usuario.Usuario;
import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Table(name = "administrador")
@Entity(name = "Administrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrador extends Pessoa {

    private String nome;
    private String cpf;

    public Administrador(String nome, String cpf, String telefone, Usuario usuario, DTOEndereco endereco) {
        super(telefone, usuario, endereco);
        this.nome = nome;
        this.cpf = cpf;
    }


    public void atualizar(String nome, String telefone, DTOEndereco endereco ) {
        super.atualizar(telefone, endereco);
        this.nome = nome;
    }
}