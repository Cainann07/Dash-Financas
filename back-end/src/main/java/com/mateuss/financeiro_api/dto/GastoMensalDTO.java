package com.mateuss.financeiro_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoMensalDTO {
    private String nome;
    private BigDecimal valor;
    private int diaVencimento;
    private boolean valorVariavel;
    private LocalDate dataUltimoPagamento;

    public GastoMensalDTO(String nome, BigDecimal valor, int diaVencimento, boolean valorVariavel, LocalDate dataUltimoPagamento) {
        this.nome = nome;
        this.valor = valor;
        this.diaVencimento = diaVencimento;
        this.valorVariavel = valorVariavel;
        this.dataUltimoPagamento = dataUltimoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public boolean isValorVariavel() {
        return valorVariavel;
    }

    public void setValorVariavel(boolean valorVariavel) {
        this.valorVariavel = valorVariavel;
    }

    public LocalDate getDataUltimoPagamento() {
        return dataUltimoPagamento;
    }

    public void setDataUltimoPagamento(LocalDate dataUltimoPagamento) {
        this.dataUltimoPagamento = dataUltimoPagamento;
    }

    @Override
    public String toString() {
        return "GastoMensalDTORequest{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", diaVencimento=" + diaVencimento +
                ", valorVariavel=" + valorVariavel +
                ", dataUltimoPagamento=" + dataUltimoPagamento +
                '}';
    }
}
