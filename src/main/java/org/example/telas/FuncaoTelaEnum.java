package org.example.telas;

import java.util.Arrays;

public enum FuncaoTelaEnum {
    TELA_CADASTRO("Cadastrar Nova Conta", 1, true) {
        @Override
        public Tela createTela() {
            return new TelaCadastrarConta();
        }
    }, TELA_DEPOSITO("Deposito", 2, true) {
        @Override
        public Tela createTela() {
            return new TelaRealizarTransacaoDeposito();
        }
    }, TELA_SAQUE("Saque", 3, true) {
        @Override
        public Tela createTela() {
            return new TelaRealizarTransacaoSaque();
        }
    }, TELA_SALDO("Saldo", 4, true) {
        @Override
        public Tela createTela() {
            return new TelaObterSaldo();
        }
    }, TELA_INFOERRADA("Informação errada", 99, false) {
        @Override
        public Tela createTela() {
            return new TelaInformacaoErrada();
        }
    }, TELA_SAIR("Sair", 0, true) {
        @Override
        public Tela createTela() {
            return new TelaSair();
        }
    };

    private String label;
    private int opcao;

    private boolean visivel;

    private FuncaoTelaEnum(String label, int opcao, boolean visivel) {
        this.label = label;
        this.opcao = opcao;
        this.visivel = visivel;
    }

    public static FuncaoTelaEnum getFuncaoPorOpcao(int opcao) {
        return Arrays.stream(FuncaoTelaEnum.values())
                .filter(funcaoTelaEnum -> funcaoTelaEnum.getOpcao() == opcao)
                .findFirst().orElse(TELA_INFOERRADA);
    }

    public abstract Tela createTela();

    public String getLabel() {
        return label;
    }

    public int getOpcao() {
        return opcao;
    }

    public boolean isVisivel() {
        return visivel;
    }
}
