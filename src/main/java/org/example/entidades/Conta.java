package org.example.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Conta {
    private String numero;
    private int agencia;
    private Cliente cliente;

    private TipoConta tipoConta;

    private ArrayList<Transacao> transacoes;


    public Conta(String numero, int agencia, Cliente cliente, TipoConta tipoConta) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        transacoes = new ArrayList<>();
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

    public void realizarDeposito(BigDecimal valor){
       transacoes.add(new Transacao(this,valor, TipoTransacao.DEPOSITO));
    }

    public void realizarSaque(BigDecimal valor){
        transacoes.add(new Transacao(this, valor, TipoTransacao.SAQUE));
    }

    public BigDecimal saldo(){

        return somaPorTipo(TipoTransacao.SAQUE).subtract(somaPorTipo(TipoTransacao.DEPOSITO));
    }
    private BigDecimal somaPorTipo(TipoTransacao tipoTransacao){

        return transacoes.stream()
                .filter(transacao -> tipoTransacao.equals(transacao.getTipoTransacao()))
                .map(Transacao::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean filter(Transacao transacao){
        return TipoTransacao.DEPOSITO.equals(transacao.getTipoTransacao());
    }
}
