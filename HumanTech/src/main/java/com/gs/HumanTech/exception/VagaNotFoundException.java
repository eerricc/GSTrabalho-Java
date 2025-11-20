package com.gs.HumanTech.exception;

public class VagaNotFoundException extends RuntimeException {
    public VagaNotFoundException(Integer message) {

        super("Vaga com ID: " + message + " não encontrada.");
    }
}
