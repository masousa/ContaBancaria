package org.example;


import org.example.excecao.ContaNaoEncontradaException;
import org.example.fabrica.TelaFabrica;
import org.example.telas.Tela;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(entryHelpFile().toFile());
        System.out.println("Bem vindo ao banco New Banco");

        int opcao = 0;
        do {
            System.out.println(" (1) - Cadastrar Nova Conta \n (2) - Deposito \n (3) - Saque \n (4) - Saldo \n (0) - Sair");
            opcao = scanner.nextInt();
            try {
                Tela tela = TelaFabrica.getInstance(opcao);
                tela.executar(scanner);
            } catch (ContaNaoEncontradaException exception) {
                System.err.println(exception.getMessage());
            }

        } while (opcao > 0);
    }

    private static Path entryHelpFile() {
        return Paths.get("src", "main", "resources", "Input.entry")
                .toAbsolutePath();
    }
}
