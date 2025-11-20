package com.gs.HumanTech.exception;

public class CandidatoNotFoundException extends BusinessException {
    public CandidatoNotFoundException(Integer message) {
        super("Candidato com ID: " + message + " não encontrado.");
    }
}
