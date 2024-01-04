package br.com.senior.reclamomesmo.controller;

import br.com.senior.reclamomesmo.dto.pessoajuridica.DTOPessoaJuridicaDetails;
import br.com.senior.reclamomesmo.dto.pessoajuridica.DTOPessoaJuridicaRegistration;
import br.com.senior.reclamomesmo.service.PessoaJuridicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/pessoa-juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @PostMapping
    ResponseEntity<DTOPessoaJuridicaDetails> criar (@RequestBody @Valid DTOPessoaJuridicaRegistration dto,
                                                    UriComponentsBuilder uriBuilder){
        var pessoaJuridica = pessoaJuridicaService.criar(dto.razaoSocial(),
                                                            dto.cnpj(),
                                                            dto.telefone(),
                                                            dto.usuario(),
                                                            dto.senha(),
                                                            dto.endereco());

        var uri = uriBuilder.path("/pessoa-juridica/{id}").buildAndExpand(pessoaJuridica.getId()).toUri();

        return ResponseEntity.created(uri).body(new DTOPessoaJuridicaDetails(pessoaJuridica));
    }

    @GetMapping
    public ResponseEntity<Page<DTOPessoaJuridicaDetails>> listarTodos(
            @PageableDefault(size = 10, sort = "razaoSocial") Pageable pageable
    ){
        var pessoaJuridicaList = pessoaJuridicaService.listar(pageable);
        return ResponseEntity.ok().body(pessoaJuridicaList.map(DTOPessoaJuridicaDetails::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOPessoaJuridicaDetails> listarPorId(@PathVariable String id){
        var pessoaJuridica = pessoaJuridicaService.listarPorId(id);
        return ResponseEntity.ok().body(new DTOPessoaJuridicaDetails(pessoaJuridica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOPessoaJuridicaDetails> atualizar(@PathVariable String id,
                                                               @RequestBody @Valid DTOPessoaJuridicaRegistration dto){
        var pessoaJuridica = pessoaJuridicaService.atualizar(id,
                                                                dto.razaoSocial(),
                                                                dto.telefone(),
                                                                dto.endereco());
        return ResponseEntity.ok().body(new DTOPessoaJuridicaDetails(pessoaJuridica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DTOPessoaJuridicaDetails> deletar(@PathVariable String id){
        pessoaJuridicaService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
