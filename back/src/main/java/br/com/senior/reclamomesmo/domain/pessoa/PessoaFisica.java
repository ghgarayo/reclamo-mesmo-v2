package br.com.senior.reclamomesmo.domain.pessoa;

import br.com.senior.reclamomesmo.domain.usuario.Usuario;
import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "pessoa_fisica")
@Entity(name = "PessoaFisica")
@Getter
@Setter
@NoArgsConstructor
public class PessoaFisica extends Pessoa{

    private String nome;
    private String cpf;

    public PessoaFisica(String nome, String cpf, String telefone, Usuario usuario, DTOEndereco endereco) {
        super(telefone, usuario, endereco);
        this.nome = nome;
        this.cpf = cpf;
    }

    public void atualizar(String nome, String telefone, DTOEndereco endereco) {
        super.atualizar(telefone, endereco);
        this.nome = nome;
    }
}
