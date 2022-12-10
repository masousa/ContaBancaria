package org.example.entidades;

public enum TipoConta {

    POUPANCA(1, "Conta Poupança"), CORRENTE(2, "Conta Corrente"), SALARIO(3, "Conta Salário");

    private int opcao;
    private String label;

    private TipoConta(int opcao, String label){
        this.opcao = opcao;
        this.label = label;
    }

    public int getOpcao() {
        return opcao;
    }

    public String getLabel() {
        return label;
    }

    public static TipoConta fromOpcao(int opcao){
        for (TipoConta tipoConta: TipoConta.values()) {
            if(tipoConta.opcao==opcao){
                return tipoConta;
            }
        }
        throw new RuntimeException("Opção inválida");
    }
}
