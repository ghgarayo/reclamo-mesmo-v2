package br.com.senior.reclamomesmo.repository;

import br.com.senior.reclamomesmo.domain.pessoa.PessoaJuridica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, String> {
    Page<PessoaJuridica> findAllByIsActiveTrue(Pageable pageable);
    PessoaJuridica findByCnpj(String cnpj);

}
