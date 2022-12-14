package org.example.entidades;

import java.math.BigDecimal;

public abstract class Conta extends ContaSalario {

    public Conta(String numero, int agencia, Cliente cliente, TipoConta tipoConta) {
        super(numero, agencia, cliente);
        super.tipoConta = tipoConta;
    }

    public void realizarDeposito(BigDecimal valor) {
        saldo = saldo.add(valor);
        transacoes.add(new Transacao(this, valor, TipoTransacao.DEPOSITO));
    }

    public abstract String extrato();

    public String transacoesImpressas() {
        //TODO implementar a impressão das transacoes
        return "";
    }

}
