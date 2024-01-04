package br.com.senior.reclamomesmo.service;

import br.com.senior.reclamomesmo.domain.pessoa.PessoaJuridica;
import br.com.senior.reclamomesmo.dto.endereco.DTOEndereco;
import br.com.senior.reclamomesmo.repository.PessoaJuridicaRepository;
import br.com.senior.reclamomesmo.util.ValidadorCnpj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public PessoaJuridica criar(String razaoSocial, String cnpj, String telefone, String email, String senha, DTOEndereco endereco) {

        var isCNPJValid = ValidadorCnpj.isCNPJ(cnpj);

        if (!isCNPJValid) {
            throw new IllegalArgumentException("CNPJ inválido");
        }

        var usuario = usuarioService.register(email, senha, false);

        var pessoaJuridica = new PessoaJuridica(razaoSocial, cnpj, telefone, usuario, endereco);
        pessoaJuridicaRepository.save(pessoaJuridica);

        return pessoaJuridica;
    }

    public Page<PessoaJuridica> listar(Pageable pageable){
        return pessoaJuridicaRepository.findAllByIsActiveTrue(pageable);
    }

    public PessoaJuridica listarPorId(String id) {
        return pessoaJuridicaRepository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException("Pessoa Jurídica não encontrada"));
    }

    public PessoaJuridica atualizar(String id, String razaoSocial, String telefone, DTOEndereco endereco) {

        var pessoaJuridica = pessoaJuridicaRepository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException("Pessoa Jurídica não encontrada"));

        pessoaJuridica.atualizar(razaoSocial, telefone, endereco);
        pessoaJuridicaRepository.save(pessoaJuridica);

        return pessoaJuridica;
    }

    public void deletar(String id) {
        var pessoaJuridica = pessoaJuridicaRepository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException("Pessoa Jurídica não encontrada"));

        pessoaJuridica.inativar();
        pessoaJuridicaRepository.save(pessoaJuridica);
    }


}
