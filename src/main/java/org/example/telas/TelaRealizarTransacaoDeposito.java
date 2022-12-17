package org.example.telas;

import org.example.entidades.Conta;
import org.example.entidades.ContaSalario;
import org.example.entidades.TipoConta;
import org.example.excecao.ContaNaoEncontradaException;
import org.example.persistencia.ContaPersistencia;

import java.math.BigDecimal;
import java.util.Scanner;

public class TelaRealizarTransacaoDeposito implements Tela {
    public void executar(Scanner scanner) throws ContaNaoEncontradaException {
        System.out.println("Número da conta para realização do deposito");

        ContaSalario conta = ContaPersistencia.pesquisarPorNumeroDaConta(scanner.next())
                .orElseThrow(ContaNaoEncontradaException::new);

        if (TipoConta.SALARIO.equals(conta.getTipoConta())) {
            throw new RuntimeException("Esta conta não permite esta operação");
        }
        System.out.println("Valor a ser depositado");
        var valorTransacao = BigDecimal.valueOf(scanner.nextDouble());

        var contaNormal = (Conta) conta;
        contaNormal.realizarDeposito(valorTransacao);

    }
}
