package org.example.entidades;

public class ContaCorrente extends Conta{

    public ContaCorrente(String numero, int agencia, Cliente cliente) {
        super(numero, agencia, cliente, TipoConta.SALARIO);

    }

    public void transferencia(){
        // TODO implementar transferencia;
    }

    @Override
    public String extrato() {
        return String.format("Conta corrente Saldo %.2f %n Transacoes %n\t %s %n Transferências %n",
                saldo,transacoesImpressas());
    }
}
