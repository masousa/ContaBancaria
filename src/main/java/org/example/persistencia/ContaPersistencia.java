package org.example.persistencia;

import org.example.entidades.Conta;

import java.util.ArrayList;
import java.util.Optional;

public class ContaPersistencia {
    private static ArrayList<Conta> contas = new ArrayList<>();

    public static void adicionar(Conta conta){
        contas.add(conta);
    }
    public static Optional<Conta> pesquisarPorNumeroDaConta(String numeroConta){

        return contas.stream()
                .filter(conta -> conta.getNumero().equals(numeroConta)).findFirst();
    }

}
