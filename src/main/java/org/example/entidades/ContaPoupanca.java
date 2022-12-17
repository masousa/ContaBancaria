package org.example.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaPoupanca extends Conta {
    private static final BigDecimal TARIFA = BigDecimal.valueOf(0.002);
    private ArrayList<BigDecimal> tarifasAplicadas;

    public ContaPoupanca(String numero, int agencia, Cliente cliente) {
        super(numero, agencia, cliente, TipoConta.POUPANCA);
        tarifasAplicadas = new ArrayList<>();
    }

    @Override
    public void realizarSaque(BigDecimal valor) {
        final BigDecimal tarifaAplicada = valor.multiply(TARIFA);
        tarifasAplicadas.add(tarifaAplicada);
        BigDecimal valorMaisTarifa = valor.add(tarifaAplicada);
        super.realizarSaque(valorMaisTarifa);

    }

    @Override
    public void realizarSaque(double valorDouble) {
        this.realizarSaque(BigDecimal.valueOf(valorDouble));
    }

    @Override
    public String extrato() {
        return String.format("Conta Poupança de saldo %.2f %n Transações %n\t %s %n\t Total de tarifas aplicadas %.2f",
                saldo().doubleValue(), transacoesImpressas(), calcularTotalTarifas());
    }

    private BigDecimal calcularTotalTarifas() {
        return tarifasAplicadas.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
