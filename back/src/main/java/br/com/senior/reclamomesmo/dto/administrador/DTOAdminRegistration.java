package br.com.senior.reclamomesmo.dto.administrador;

import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOAdminRegistration(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String usuario,
        @NotBlank
        String senha,
        @Valid
        DTOEndereco endereco

) {
}
