package br.com.senior.reclamomesmo.repository;

import br.com.senior.reclamomesmo.domain.pessoa.Administrador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, String> {
    Page<Administrador> findAllByIsActiveTrue(Pageable pageable);
}
