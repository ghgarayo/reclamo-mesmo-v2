package br.com.senior.reclamomesmo.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        String numero,
        String complemento,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf){
}
