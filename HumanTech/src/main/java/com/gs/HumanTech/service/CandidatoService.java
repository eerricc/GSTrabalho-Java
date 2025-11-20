package com.gs.HumanTech.service;

import com.gs.HumanTech.dto.CreateCandidatoDto;
import com.gs.HumanTech.dto.ResponseCandidatoDto;
import com.gs.HumanTech.exception.CandidatoNotFoundException;
import com.gs.HumanTech.model.CandidatoModel;
import com.gs.HumanTech.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public ResponseCandidatoDto createCandidato(CreateCandidatoDto dto) {
        CandidatoModel candidato = new CandidatoModel();
        candidato.setNome(dto.getNome());
        candidato.setEmail(dto.getEmail());

        candidatoRepository.saveCandidato(candidato);
        return toResponse(candidato);
    }

    public ResponseCandidatoDto getCandidatoById(Integer id) {
        CandidatoModel candidato = candidatoRepository.findById(id);

        if (candidato == null) {
            throw new CandidatoNotFoundException(id);
        }

        return toResponse(candidato);
    }

    public List<ResponseCandidatoDto> getAllCandidatos() {
        List<CandidatoModel> candidatos = candidatoRepository.findAll();

        return candidatos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ResponseCandidatoDto updateCandidato(Integer id, CreateCandidatoDto dto) {
        CandidatoModel existing = candidatoRepository.findById(id);

        if (existing == null) {
            throw new CandidatoNotFoundException(id);
        }

        existing.setNome(dto.getNome());
        existing.setEmail(dto.getEmail());

        candidatoRepository.updateCandidato(existing);
        return toResponse(existing);
    }

    public void deleteCandidato(Integer id) {
        CandidatoModel existing = candidatoRepository.findById(id);
        if (existing == null) {
            throw new CandidatoNotFoundException(id);
        }

        candidatoRepository.deleteCandidato(id);
    }

    private ResponseCandidatoDto toResponse(CandidatoModel candidato) {
        ResponseCandidatoDto dto = new ResponseCandidatoDto();
        dto.setId_candidato(candidato.getId_candidato());
        dto.setNome(candidato.getNome());
        dto.setEmail(candidato.getEmail());
        return dto;
    }
}
