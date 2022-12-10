package org.example;


import org.example.excecao.ContaNaoEncontradaException;
import org.example.telas.TelaCadastrarConta;
import org.example.telas.TelaRealizarTransacaoDeposito;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Bem vindo ao banco New Banco" );

        int opcao=0;
        do{
            System.out.println(" (1) - Cadastrar Nova Conta \n (2) - Deposito \n (0) - Sair");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:

                    TelaCadastrarConta.cadastrar(scanner);
                    break;
                case 2:
                    try {
                        TelaRealizarTransacaoDeposito.realizarTransacao(scanner);
                    }catch (ContaNaoEncontradaException exception){
                        System.err.println(exception.getMessage());
                    }

                case 0:
                    System.out.println("Até logo!!!");
                    break;
                default:
                    System.out.println("Opção inválida");

            }

        }while(opcao>0);
    }
}
