package com.gs.HumanTech.controller;

import com.gs.HumanTech.dto.CreateCandidatoDto;
import com.gs.HumanTech.dto.ResponseCandidatoDto;
import com.gs.HumanTech.service.CandidatoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @Operation(summary = "Cria um novo candidato")
    @PostMapping
    public ResponseEntity<ResponseCandidatoDto> create(@RequestBody CreateCandidatoDto dto) {
        return ResponseEntity.ok(candidatoService.createCandidato(dto));
    }

    @Operation(summary = "Busca um candidato por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseCandidatoDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(candidatoService.getCandidatoById(id));
    }

    @Operation(summary = "Lista todos os candidatos")
    @GetMapping
    public ResponseEntity<List<ResponseCandidatoDto>> getAll() {
        return ResponseEntity.ok(candidatoService.getAllCandidatos());
    }

    @Operation(summary = "Atualiza um candidato existente")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseCandidatoDto> update(@PathVariable Integer id, @RequestBody CreateCandidatoDto dto) {
        return ResponseEntity.ok(candidatoService.updateCandidato(id, dto));
    }

    @Operation(summary = "Deleta um candidato existente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        candidatoService.deleteCandidato(id);
        return ResponseEntity.noContent().build();
    }
}
