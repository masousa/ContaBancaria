package org.example;


import org.example.excecao.ContaNaoEncontradaException;
import org.example.telas.TelaCadastrarConta;
import org.example.telas.TelaRealizarTransacaoDeposito;
import org.example.telas.TelaRealizarTransacaoSaque;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao banco New Banco");

        int opcao = 0;
        do {
            System.out.println(" (1) - Cadastrar Nova Conta \n (2) - Deposito \n (3) - Saque \n (0) - Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:

                    TelaCadastrarConta.cadastrar(scanner);
                    break;
                case 2:
                    try {
                        TelaRealizarTransacaoDeposito.realizarTransacao(scanner);
                    } catch (ContaNaoEncontradaException exception) {
                        System.err.println(exception.getMessage());
                    }
                    break;
                case 3:
                    try {
                        TelaRealizarTransacaoSaque.realizarTransacao(scanner);
                    } catch (ContaNaoEncontradaException contaNaoEncontradaException) {
                        System.err.println("Não é possível fazer o saque");
                    }
                    break;
                case 0:
                    System.out.println("Até logo!!!");
                    break;
                default:
                    System.out.println("Opção inválida");

            }

        } while (opcao > 0);
    }

    private static Path entryHelpFile() {
        return Paths.get("src", "main", "resources", "Input.entry")
                .toAbsolutePath();
    }
}
