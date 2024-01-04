package br.com.senior.reclamomesmo.controller;

import br.com.senior.reclamomesmo.dto.pessoafisica.DTOPessoaFisicaDetails;
import br.com.senior.reclamomesmo.dto.pessoafisica.DTOPessoaFisicaRegistration;
import br.com.senior.reclamomesmo.service.PessoaFisicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/pessoa-fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public ResponseEntity<DTOPessoaFisicaDetails> criar(@RequestBody @Valid DTOPessoaFisicaRegistration dto,
                                                        UriComponentsBuilder uriBuilder) {

        var pessoaFisica = pessoaFisicaService.criar(dto.nome(),
                dto.cpf(),
                dto.telefone(),
                dto.email(),
                dto.senha(),
                dto.endereco());

        var uri = uriBuilder.path("/pessoa-fisica/{id}").buildAndExpand(pessoaFisica.getId()).toUri();

        return ResponseEntity.created(uri).body(new DTOPessoaFisicaDetails(pessoaFisica));
    }

    @GetMapping
    public ResponseEntity<Page<DTOPessoaFisicaDetails>> listarTodos(
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        var pessoaFisicaList = pessoaFisicaService.listar(pageable);

        return ResponseEntity.ok().body(pessoaFisicaList.map(DTOPessoaFisicaDetails::new));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DTOPessoaFisicaDetails> listarPorId(@PathVariable String id) {
        var pessoaFisica = pessoaFisicaService.listarPorId(id);
        return ResponseEntity.ok().body(new DTOPessoaFisicaDetails(pessoaFisica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOPessoaFisicaDetails> atualizar(@PathVariable String id,
                                                            @RequestBody @Valid DTOPessoaFisicaRegistration dto) {
        var pessoaFisica = pessoaFisicaService.atualizar(id,
                dto.nome(),
                dto.telefone(),
                dto.endereco());
        return ResponseEntity.ok().body(new DTOPessoaFisicaDetails(pessoaFisica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        pessoaFisicaService.inativar(id);
        return ResponseEntity.noContent().build();
    }


}
