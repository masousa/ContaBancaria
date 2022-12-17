package org.example.telas;

import org.example.entidades.ContaSalario;
import org.example.excecao.ContaNaoEncontradaException;

import java.util.Scanner;

public class TelaRealizarTransacaoSaque extends Tela {
    public void executar(Scanner scanner) throws ContaNaoEncontradaException {

        ContaSalario conta =
                getContaSalario("Número da conta para realização do saque", scanner);

        System.out.println("Valor a ser sacado");

        conta.realizarSaque(scanner.nextDouble());

    }

}
