package org.example.fabrica;

import org.example.telas.Tela;
import org.example.telas.TelaCadastrarConta;
import org.example.telas.TelaObterSaldo;
import org.example.telas.TelaRealizarTransacaoDeposito;
import org.example.telas.TelaRealizarTransacaoSaque;

public class TelaFabrica {

    public static Tela getInstance(int opcao) {
        switch (opcao) {
            case 1:
                return new TelaCadastrarConta();
            case 2:
                return new TelaRealizarTransacaoDeposito();
            case 3:
                return new TelaRealizarTransacaoSaque();
            case 4:
                return new TelaObterSaldo();
            case 0:
                System.out.println("Até logo!!!");
                break;

        }

        System.out.println("Opção inválida");
        return null;
    }
}
