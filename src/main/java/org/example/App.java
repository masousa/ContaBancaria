package org.example;


import org.example.excecao.ContaNaoEncontradaException;
import org.example.telas.FuncaoTelaEnum;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(entryHelpFile().toFile());
        System.out.println("Bem vindo ao banco New Banco");
        FuncaoTelaEnum funcaoTelaEnum = FuncaoTelaEnum.TELA_SAIR;
        do {

            try {
                funcaoTelaEnum = getFuncao(scanner);
                funcaoTelaEnum.createTela().executar(scanner);

            } catch (ContaNaoEncontradaException exception) {
                System.err.println(exception.getMessage());
            }

        } while (!FuncaoTelaEnum.TELA_SAIR.equals(funcaoTelaEnum));
    }

    private static FuncaoTelaEnum getFuncao(Scanner scanner) {
        System.out.println("Informe uma das opções abaixo:");
        Arrays.stream(FuncaoTelaEnum.values()).filter(FuncaoTelaEnum::isVisivel).forEachOrdered(App::printEachOption);
        int opcao = scanner.nextInt();
        return FuncaoTelaEnum.getFuncaoPorOpcao(opcao);
    }

    private static void printEachOption(FuncaoTelaEnum funcaoTelaEnum) {
        System.out.printf("(%d) - %s %n", funcaoTelaEnum.getOpcao(), funcaoTelaEnum.getLabel());
    }

    private static Path entryHelpFile() {
        return Paths.get("src", "main", "resources", "Input.entry")
                .toAbsolutePath();
    }
}
