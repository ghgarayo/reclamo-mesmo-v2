package br.com.senior.reclamomesmo.service;

import br.com.senior.reclamomesmo.domain.pessoa.Administrador;
import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import br.com.senior.reclamomesmo.infra.exception.ValidacaoException;
import br.com.senior.reclamomesmo.repository.AdministradorRepository;
import br.com.senior.reclamomesmo.util.ValidadorCpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Administrador criar(String nome, String cpf, String telefone, String email, String senha, DTOEndereco endereco) {

        var isCpfvalid = ValidadorCpf.isCPF(cpf);

        if(!isCpfvalid){
            throw new ValidacaoException("CPF inválido");
        }

        var usuario = usuarioService.register(email, senha, true);

        var administrador = new Administrador(nome, cpf, telefone, usuario, endereco);
        administradorRepository.save(administrador);

        return administrador;
    }

    public Page<Administrador> listar(Pageable pageable) {
        return administradorRepository.findAllByIsActiveTrue(pageable);
    }

    public Administrador listarPorId(String id) {
        return administradorRepository.findById(id)
                .orElseThrow(
                        ()-> new NoSuchElementException("Administrador não encontrado"));
    }

    public Administrador atualizar(String id, String nome, String telefone, DTOEndereco endereco) {

            var administrador = administradorRepository.findById(id)
                    .orElseThrow(
                            ()-> new NoSuchElementException("Administrador não encontrado"));

            administrador.atualizar(nome, telefone, endereco);
            administradorRepository.save(administrador);

            return administrador;
    }

    public void inativar(String id) {
        var administrador = administradorRepository.findById(id)
                .orElseThrow(
                        ()-> new NoSuchElementException("Administrador não encontrado"));

        administrador.inativar();
        administradorRepository.save(administrador);
    }
}

