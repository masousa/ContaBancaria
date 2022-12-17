package org.example.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ContaSalario {
    private String numero;
    private int agencia;
    private Cliente cliente;

    protected TipoConta tipoConta;

    protected List<Transacao> transacoes;

    protected BigDecimal saldo;


    public ContaSalario(String numero, int agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        this.tipoConta = TipoConta.SALARIO;
        transacoes = new ArrayList<>();
        saldo = BigDecimal.ZERO;
    }

    public String getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }


    public void realizarSaque(BigDecimal valor) {

        BigDecimal saldoPValidar = saldo.subtract(valor);
        if (saldoPValidar.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Não há saldo suficiente");
        }
        saldo = saldoPValidar;
        transacoes.add(new Transacao(this, valor, TipoTransacao.SAQUE));
    }

    public void realizarSaque(double valorDouble) {
        realizarSaque(BigDecimal.valueOf(valorDouble));
    }

    public BigDecimal saldo() {

        return this.saldo;
    }

    @Override
    public String toString() {

        return String.format("Conta %s de saldo %.2f", this.getNumero(), this.saldo.doubleValue());
    }
}
