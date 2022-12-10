package org.example.excecao;

public class ContaNaoEncontradaException extends Exception{
    public ContaNaoEncontradaException(){
        super("Conta não encontrada");
    }
}
