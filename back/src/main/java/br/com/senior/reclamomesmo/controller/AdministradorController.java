package br.com.senior.reclamomesmo.controller;

import br.com.senior.reclamomesmo.dto.administrador.DTOAdminDetails;
import br.com.senior.reclamomesmo.dto.administrador.DTOAdminRegistration;
import br.com.senior.reclamomesmo.service.AdministradorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/admin")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    @Transactional
    public ResponseEntity<DTOAdminDetails> criar(@RequestBody @Valid DTOAdminRegistration dto,
                                                 UriComponentsBuilder uriBuilder) {

        var administrador = administradorService.criar(dto.nome(),
                dto.cpf(),
                dto.telefone(),
                dto.usuario(),
                dto.senha(),
                dto.endereco());

        var uri = uriBuilder.path("/admin/{id}").buildAndExpand(administrador.getId()).toUri();

        return ResponseEntity.created(uri).body(new DTOAdminDetails(administrador));
    }

    @GetMapping
    public ResponseEntity<Page<DTOAdminDetails>> listarTodos(
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        var administradorList = administradorService.listar(pageable);
        return ResponseEntity.ok().body(administradorList.map(DTOAdminDetails::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOAdminDetails> listarPorId(@PathVariable String id) {
        var administrador = administradorService.listarPorId(id);
        return ResponseEntity.ok().body(new DTOAdminDetails(administrador));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DTOAdminDetails> atualizar(@PathVariable String id,
                                                     @RequestBody @Valid DTOAdminRegistration dto) {
        var administrador = administradorService.atualizar(id,
                dto.nome(),
                dto.telefone(),
                dto.endereco());

        return ResponseEntity.ok().body(new DTOAdminDetails(administrador));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> inativar(@PathVariable String id) {
        administradorService.inativar(id);
        return ResponseEntity.ok().build();
    }

}
