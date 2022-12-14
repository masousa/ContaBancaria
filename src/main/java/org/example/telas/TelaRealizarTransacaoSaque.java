package org.example.telas;

import org.example.entidades.ContaSalario;
import org.example.excecao.ContaNaoEncontradaException;
import org.example.persistencia.ContaPersistencia;

import java.util.Scanner;

public class TelaRealizarTransacaoSaque implements Tela {
    public void executar(Scanner scanner) throws ContaNaoEncontradaException {
        System.out.println("Número da conta para realização do saque");

        ContaSalario conta = ContaPersistencia.pesquisarPorNumeroDaConta(scanner.next())
                .orElseThrow(ContaNaoEncontradaException::new);

        System.out.println("Valor a ser sacado");

        conta.realizarSaque(scanner.nextDouble());

    }

}
