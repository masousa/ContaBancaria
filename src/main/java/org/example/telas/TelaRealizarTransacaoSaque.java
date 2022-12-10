package org.example.telas;

import org.example.entidades.Conta;
import org.example.excecao.ContaNaoEncontradaException;
import org.example.persistencia.ContaPersistencia;

import java.math.BigDecimal;
import java.util.Scanner;

public class TelaRealizarTransacaoSaque {
    public void realizarTransacao(Scanner scanner) throws ContaNaoEncontradaException{
        System.out.println("Número da conta para realização do deposito");

        Conta conta = ContaPersistencia.pesquisarPorNumeroDaConta(scanner.next())
                .orElseThrow(ContaNaoEncontradaException::new);

        System.out.println("Valor a ser sacado");
        BigDecimal valorTransacao = BigDecimal.valueOf(scanner.nextDouble());

        conta.realizarSaque(valorTransacao);

    }
}
