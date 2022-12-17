package org.example.telas;

import org.example.entidades.Conta;
import org.example.entidades.ContaSalario;
import org.example.entidades.TipoConta;
import org.example.excecao.ContaNaoEncontradaException;

import java.math.BigDecimal;
import java.util.Scanner;

public class TelaRealizarTransacaoDeposito extends Tela {
    public void executar(Scanner scanner) throws ContaNaoEncontradaException {
        ContaSalario conta =
                getContaSalario("Número da conta para realização do deposito", scanner);

        if (TipoConta.SALARIO.equals(conta.getTipoConta())) {
            throw new RuntimeException("Esta conta não permite esta operação");
        }
        System.out.println("Valor a ser depositado");
        var valorTransacao = BigDecimal.valueOf(scanner.nextDouble());

        var contaNormal = (Conta) conta;
        contaNormal.realizarDeposito(valorTransacao);

    }
}
