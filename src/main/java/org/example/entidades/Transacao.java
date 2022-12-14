package org.example.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {

    public LocalDateTime dataTransacao;
    public ContaSalario destinatario;
    public BigDecimal valor;

    private TipoTransacao tipoTransacao;

    public Transacao(ContaSalario destinatario, BigDecimal valor, TipoTransacao tipoTransacao) {
        this.destinatario = destinatario;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        dataTransacao = LocalDateTime.now();
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public ContaSalario getDestinatario() {
        return destinatario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }
}
