package org.example.telas;

import org.example.entidades.ContaSalario;
import org.example.excecao.ContaNaoEncontradaException;
import org.example.persistencia.ContaPersistencia;

import java.util.Scanner;

public abstract class Tela {
    public abstract void executar(Scanner scanner) throws ContaNaoEncontradaException;

    public ContaSalario getContaSalario(String message, Scanner scanner) throws ContaNaoEncontradaException {
        System.out.println(message);// "Número da conta para realização do deposito");

        return ContaPersistencia.pesquisarPorNumeroDaConta(scanner.next())
                .orElseThrow(ContaNaoEncontradaException::new);
    }
}
