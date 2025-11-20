package com.gs.HumanTech.service;

import com.gs.HumanTech.dto.CreateVagaDto;
import com.gs.HumanTech.dto.ResponseVagaDto;
import com.gs.HumanTech.exception.VagaNotFoundException;
import com.gs.HumanTech.model.VagaModel;
import com.gs.HumanTech.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    // CREATE
    public ResponseVagaDto createVaga(CreateVagaDto dto) {
        VagaModel vaga = new VagaModel();
        vaga.setTitulo(dto.getTitulo());
        vaga.setTipo_trabalho(dto.getTipoTrabalho());
        vaga.setSalario(dto.getSalario());
        vaga.setDescricao(dto.getDescricao());

        vagaRepository.saveVaga(vaga);
        return toResponse(vaga);
    }

    // READ - Buscar por ID
    public ResponseVagaDto getVagaById(Integer id) {
        VagaModel vaga = vagaRepository.findById(id);

        if (vaga == null) {
            throw new VagaNotFoundException(id);
        }

        return toResponse(vaga);
    }

    // READ - Listar todas
    public List<ResponseVagaDto> getAllVagas() {
        List<VagaModel> vagas = vagaRepository.findAll();

        return vagas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // UPDATE (usando o mesmo DTO de Create)
    public ResponseVagaDto updateVaga(Integer id, CreateVagaDto dto) {
        VagaModel existing = vagaRepository.findById(id);

        if (existing == null) {
            throw new VagaNotFoundException(id);
        }

        existing.setTitulo(dto.getTitulo());
        existing.setTipo_trabalho(dto.getTipoTrabalho());
        existing.setSalario(dto.getSalario());
        existing.setDescricao(dto.getDescricao());

        vagaRepository.updateVaga(existing);
        return toResponse(existing);
    }

    // DELETE
    public void deleteVaga(Integer id) {
        VagaModel existing = vagaRepository.findById(id);
        if (existing == null) {
            throw new VagaNotFoundException(id);
        }

        vagaRepository.deleteVaga(id);
    }

    // Converte Model para DTO de resposta
    private ResponseVagaDto toResponse(VagaModel vaga) {
        ResponseVagaDto dto = new ResponseVagaDto();
        dto.setId_vaga(vaga.getId_vaga());
        dto.setTitulo(vaga.getTitulo());
        dto.setTipo_trabalho(vaga.getTipo_trabalho());
        dto.setSalario(vaga.getSalario());
        dto.setDescricao(vaga.getDescricao());
        return dto;
    }
}
