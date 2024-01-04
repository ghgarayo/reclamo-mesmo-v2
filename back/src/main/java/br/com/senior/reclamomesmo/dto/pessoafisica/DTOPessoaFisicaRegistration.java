package br.com.senior.reclamomesmo.dto.pessoafisica;

import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOPessoaFisicaRegistration(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha,
        @Valid
        DTOEndereco endereco) {
}
