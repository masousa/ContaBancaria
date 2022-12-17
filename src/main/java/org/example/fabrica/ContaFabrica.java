package org.example.fabrica;

import org.example.entidades.Cliente;
import org.example.entidades.ContaCorrente;
import org.example.entidades.ContaPoupanca;
import org.example.entidades.ContaSalario;
import org.example.entidades.TipoConta;

public class ContaFabrica {
    private ContaFabrica() {
    }

    public static ContaSalario getInstance(TipoConta tipoConta, String numero, int agencia, Cliente cliente) {
        switch (tipoConta) {
            case CORRENTE:
                return new ContaCorrente(numero, agencia, cliente);
            case POUPANCA:
                return new ContaPoupanca(numero, agencia, cliente);
            case SALARIO:
                return new ContaSalario(numero, agencia, cliente);
        }
        return null;
    }
}
