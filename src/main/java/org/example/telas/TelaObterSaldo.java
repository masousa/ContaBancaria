package org.example.telas;

import org.example.entidades.ContaSalario;
import org.example.excecao.ContaNaoEncontradaException;
import org.example.persistencia.ContaPersistencia;

import java.util.Scanner;

public class TelaObterSaldo implements Tela {

    @Override
    public void executar(Scanner scanner) throws ContaNaoEncontradaException {
        System.out.println("Número da conta para obtenção do saldo");

        ContaSalario conta = ContaPersistencia.pesquisarPorNumeroDaConta(scanner.next())
                .orElseThrow(ContaNaoEncontradaException::new);

        double saldo = conta.saldo().doubleValue();
        System.out.printf("Sua conta %s do tipo %s tem saldo de %.2f %n", conta.getNumero(),
                conta.getTipoConta().getLabel(), saldo);
    }
}
