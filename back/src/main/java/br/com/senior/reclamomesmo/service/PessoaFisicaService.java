package br.com.senior.reclamomesmo.service;

import br.com.senior.reclamomesmo.domain.pessoa.PessoaFisica;
import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import br.com.senior.reclamomesmo.infra.exception.ValidacaoException;
import br.com.senior.reclamomesmo.repository.PessoaFisicaRepository;
import br.com.senior.reclamomesmo.util.ValidadorCpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public PessoaFisica criar(String nome, String cpf, String telefone, String email, String senha, DTOEndereco endereco) {

        var isCpfvalid = ValidadorCpf.isCPF(cpf);

        if (!isCpfvalid) {
            throw new ValidacaoException("CPF inválido");
        }

        var usuario = usuarioService.register(email, senha, false);

        var pessoaFisica = new PessoaFisica(nome, cpf, telefone, usuario, endereco);
        pessoaFisicaRepository.save(pessoaFisica);

        return pessoaFisica;
    }

    public Page<PessoaFisica> listar(Pageable pageable) {
        return pessoaFisicaRepository.findAllByIsActiveTrue(pageable);
    }

    public PessoaFisica listarPorId(String id) {
        return pessoaFisicaRepository.findById(id)
                .orElseThrow(
                        () -> new ValidacaoException("Pessoa Física não encontrada"));
    }

    public PessoaFisica atualizar(String id, String nome, String telefone, DTOEndereco endereco) {

        var pessoaFisica = pessoaFisicaRepository.findById(id)
                .orElseThrow(
                        () -> new ValidacaoException("Pessoa Física não encontrada"));

        pessoaFisica.atualizar(nome, telefone, endereco);
        pessoaFisicaRepository.save(pessoaFisica);

        return pessoaFisica;
    }

    public void inativar(String id) {
        var pessoaFisica = pessoaFisicaRepository.findById(id)
                .orElseThrow(
                        () -> new ValidacaoException("Pessoa Física não encontrada"));

        pessoaFisica.inativar();
        pessoaFisicaRepository.save(pessoaFisica);
    }


}
