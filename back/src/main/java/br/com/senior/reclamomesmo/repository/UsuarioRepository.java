package br.com.senior.reclamomesmo.repository;

import br.com.senior.reclamomesmo.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    UserDetails findByLogin(String login);

    @Query("""
               SELECT u
               FROM Usuario u
               WHERE u.id = :usuarioId AND u.isAdmin = :isAdmin
            """)
    Usuario findByIdAndIsAdmin(String usuarioId, boolean isAdmin);

    @Query("""
                SELECT u
                FROM Usuario u
                LEFT JOIN PessoaFisica pf ON u.id = pf.usuario.id
                LEFT JOIN PessoaJuridica pj ON u.id = pj.usuario.id
                LEFT JOIN Administrador a ON u.id = a.usuario.id
                WHERE u.id = :usuarioId AND (pf.isActive = true OR pj.isActive = true OR a.isActive = true)
            """)
    Usuario findByUsuarioIdAndIsActiveTrue(String usuarioId);

}