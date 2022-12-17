package org.example.telas;

import org.example.excecao.ContaNaoEncontradaException;

import java.util.Scanner;

public class TelaInformacaoErrada extends Tela {
    @Override
    public void executar(Scanner scanner) throws ContaNaoEncontradaException {
        System.err.println("Opção Errada");
    }
}
