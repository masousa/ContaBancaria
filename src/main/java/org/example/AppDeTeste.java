package org.example;

import org.example.entidades.Cliente;
import org.example.entidades.ContaPoupanca;

public class AppDeTeste {
    public static void main(String[] args) {
        ContaPoupanca contaPoupanca = new ContaPoupanca("111", 111, new Cliente());
        System.out.println(contaPoupanca.toString());
    }
}
