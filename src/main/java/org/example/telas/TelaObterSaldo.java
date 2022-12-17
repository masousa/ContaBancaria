package org.example.telas;

import org.example.entidades.ContaSalario;
import org.example.excecao.ContaNaoEncontradaException;

import java.util.Scanner;

public class TelaObterSaldo extends Tela {

    @Override
    public void executar(Scanner scanner) throws ContaNaoEncontradaException {

        ContaSalario conta =
                getContaSalario("Número da conta para obtenção do saldo", scanner);

        double saldo = conta.saldo().doubleValue();
        System.out.printf("Sua conta %s do tipo %s tem saldo de %.2f %n", conta.getNumero(),
                conta.getTipoConta().getLabel(), saldo);
    }
}
