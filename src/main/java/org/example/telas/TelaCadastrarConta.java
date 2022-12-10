package org.example.telas;

import org.example.entidades.Cliente;
import org.example.entidades.Conta;
import org.example.entidades.TipoConta;
import org.example.persistencia.ContaPersistencia;

import java.util.Scanner;

public class TelaCadastrarConta {
    private static int SEQUENCIAL_CONTA_CADASTRADA = 1;
    public static void cadastrar(Scanner scanner){
        Cliente cliente = TelaBuscarCliente.buscar(scanner);

        System.out.println("Informe o número da agência onde deseja cadastrar a nova conta");
        int agenciaNumber = scanner.nextInt();

        System.out.println("Informe o tipo da conta");
        for (TipoConta tipoConta:TipoConta.values()) {
            System.out.printf(" (%d) - %s \n", tipoConta.getOpcao(), tipoConta.getLabel());
        }
        TipoConta tipoConta = TipoConta.fromOpcao(scanner.nextInt());

        String numeroConta = String.format("%07d-%d", SEQUENCIAL_CONTA_CADASTRADA,agenciaNumber);

        SEQUENCIAL_CONTA_CADASTRADA++;

        Conta conta = new Conta(numeroConta,agenciaNumber,cliente,tipoConta);
        ContaPersistencia.adicionar(conta);

        System.out.printf("Conta cadastrada. Dados da conta %n\t %s %n\t Agência :%d %n\t Número: %s %n",
                conta.getTipoConta().getLabel(), conta.getAgencia(), conta.getNumero());


    }
}
