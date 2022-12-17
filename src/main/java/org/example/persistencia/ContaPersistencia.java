package org.example.persistencia;

import org.example.entidades.ContaSalario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContaPersistencia {
    private static ArrayList<ContaSalario> contas = new ArrayList<>();

    public static void adicionar(ContaSalario conta) {
        contas.add(conta);
    }

    public static Optional<ContaSalario> pesquisarPorNumeroDaConta(String numeroConta) {

        return contas.stream()
                .filter(conta -> conta.getNumero().equals(numeroConta)).findFirst();
    }

    public static List<ContaSalario> pesquisarPorCliente(String identificador) {
        return contas.stream()
                .filter(conta ->
                        Objects.nonNull(conta.getCliente()) &&
                                conta.getCliente().getIdentificador().equals(identificador)
                )
                .collect(Collectors.toList());
    }

}
