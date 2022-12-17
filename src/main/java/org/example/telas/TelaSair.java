package org.example.telas;

import org.example.excecao.ContaNaoEncontradaException;

import java.util.Scanner;

public class TelaSair extends Tela {
    @Override
    public void executar(Scanner scanner) throws ContaNaoEncontradaException {
        System.out.println("Até logo");
    }
}
