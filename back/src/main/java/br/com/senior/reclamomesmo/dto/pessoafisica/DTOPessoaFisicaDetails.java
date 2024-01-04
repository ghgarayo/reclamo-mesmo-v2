package br.com.senior.reclamomesmo.dto.pessoafisica;

import br.com.senior.reclamomesmo.domain.endereco.Endereco;
import br.com.senior.reclamomesmo.domain.pessoa.PessoaFisica;
import br.com.senior.reclamomesmo.domain.usuario.Usuario;

public record DTOPessoaFisicaDetails(
        String id,
        String nome,
        String cpf,
        String telefone,
        Usuario usuario,
        Endereco endereco
) {

    public DTOPessoaFisicaDetails(PessoaFisica pessoaFisica) {
        this(pessoaFisica.getId(),
                pessoaFisica.getNome(),
                pessoaFisica.getCpf(),
                pessoaFisica.getTelefone(),
                pessoaFisica.getUsuario(),
                pessoaFisica.getEndereco());
    }

}
