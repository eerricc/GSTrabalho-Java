package com.gs.HumanTech.controller;

import com.gs.HumanTech.dto.CreateVagaDto;
import com.gs.HumanTech.dto.ResponseVagaDto;
import com.gs.HumanTech.service.VagaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @Operation(summary = "Cria uma nova vaga")
    @PostMapping
    public ResponseEntity<ResponseVagaDto> create(@RequestBody CreateVagaDto dto) {
        return ResponseEntity.ok(vagaService.createVaga(dto));
    }

    @Operation(summary = "Busca uma vaga por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseVagaDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(vagaService.getVagaById(id));
    }

    @Operation(summary = "Lista todas as vagas")
    @GetMapping
    public ResponseEntity<List<ResponseVagaDto>> getAll() {
        return ResponseEntity.ok(vagaService.getAllVagas());
    }

    @Operation(summary = "Atualiza uma vaga existente")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseVagaDto> update(@PathVariable Integer id, @RequestBody CreateVagaDto dto) {
        return ResponseEntity.ok(vagaService.updateVaga(id, dto));
    }

    @Operation(summary = "Deleta uma vaga existente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        vagaService.deleteVaga(id);
        return ResponseEntity.noContent().build();
    }
}
