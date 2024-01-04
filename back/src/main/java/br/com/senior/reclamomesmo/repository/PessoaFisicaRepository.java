package br.com.senior.reclamomesmo.repository;

import br.com.senior.reclamomesmo.domain.pessoa.PessoaFisica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {
    Page<PessoaFisica> findAllByIsActiveTrue(Pageable pageable);
    PessoaFisica findByCpf(String cpf);
}
