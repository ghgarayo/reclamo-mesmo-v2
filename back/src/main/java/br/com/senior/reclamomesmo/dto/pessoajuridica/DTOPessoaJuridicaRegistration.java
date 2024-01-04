package br.com.senior.reclamomesmo.dto.pessoajuridica;

import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOPessoaJuridicaRegistration(
        @NotBlank
        String razaoSocial,
        @NotBlank
        @Pattern(regexp = "\\d{14}")
        String cnpj,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String usuario,
        @NotBlank
        String senha,
        @Valid
        DTOEndereco endereco){
}
