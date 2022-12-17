package org.example.excecao;

public class TelaNaoEncontradaException extends Exception {
    public TelaNaoEncontradaException() {
        super("Informação não encontrada. Tente novamente");
    }
}
