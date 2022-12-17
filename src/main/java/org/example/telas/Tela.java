package org.example.telas;

import org.example.excecao.ContaNaoEncontradaException;

import java.util.Scanner;

public interface Tela {
    void executar(Scanner scanner) throws ContaNaoEncontradaException;
}
