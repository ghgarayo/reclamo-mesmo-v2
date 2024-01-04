package br.com.senior.reclamomesmo.domain.pessoa;

import br.com.senior.reclamomesmo.domain.usuario.Usuario;
import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "pessoa_juridica")
@Entity(name = "PessoaJuridica")
@Getter
@Setter
@NoArgsConstructor
public class PessoaJuridica extends Pessoa {

    @Column(name = "razao_social")
    private String razaoSocial;
    private String cnpj;

    public PessoaJuridica(String razaoSocial, String cnpj, String telefone, Usuario usuario, DTOEndereco endereco) {
        super(telefone, usuario, endereco);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public void atualizar(String nome, String telefone, DTOEndereco endereco) {
        super.atualizar(telefone, endereco);
        this.razaoSocial = nome;
    }
}
