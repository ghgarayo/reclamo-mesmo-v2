package br.com.senior.reclamomesmo.dto.pessoajuridica;

import br.com.senior.reclamomesmo.domain.endereco.Endereco;
import br.com.senior.reclamomesmo.domain.pessoa.PessoaJuridica;
import br.com.senior.reclamomesmo.domain.usuario.Usuario;

public record DTOPessoaJuridicaDetails(
        String id,
        String razaoSocial,
        String cnpj,
        String telefone,
        Usuario usuario,
        Endereco endereco
) {
    public DTOPessoaJuridicaDetails(PessoaJuridica pessoaJuridica) {
        this(pessoaJuridica.getId(),
                pessoaJuridica.getRazaoSocial(),
                pessoaJuridica.getCnpj(),
                pessoaJuridica.getTelefone(),
                pessoaJuridica.getUsuario(),
                pessoaJuridica.getEndereco());
    }
}

