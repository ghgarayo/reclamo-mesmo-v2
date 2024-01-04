package br.com.senior.reclamomesmo.dto.administrador;

import br.com.senior.reclamomesmo.domain.endereco.Endereco;
import br.com.senior.reclamomesmo.domain.pessoa.Administrador;
import br.com.senior.reclamomesmo.domain.usuario.Usuario;

public record DTOAdminDetails(
        String id,
        String nome,
        String cpf,
        String telefone,
        Usuario usuario,
        Endereco endereco
) {
    public DTOAdminDetails(Administrador administrador) {
        this(administrador.getId(),
                administrador.getNome(),
                administrador.getCpf(),
                administrador.getTelefone(),
                administrador.getUsuario(),
                administrador.getEndereco());
    }
}
