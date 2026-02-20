package com.mateuss.financeiro_api.dto;

import com.mateuss.financeiro_api.model.GastoMensal;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoMensalDTOResponse {

    private String nome;
    private BigDecimal valor;
    private int diaVencimento;
    private LocalDate dataUltimoPagamento;

    public GastoMensalDTOResponse(GastoMensal gastoMensal) {
        this.nome = gastoMensal.getNomeGasto();
        this.valor = gastoMensal.getValor();
        this.diaVencimento = gastoMensal.getDiaVencimento();
        this.dataUltimoPagamento = gastoMensal.getDataUltimoPagamento();
    }

    public GastoMensalDTOResponse() {
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

    public LocalDate getDataUltimoPagamento() {
        return dataUltimoPagamento;
    }

    public void setDataUltimoPagamento(LocalDate dataUltimoPagamento) {
        this.dataUltimoPagamento = dataUltimoPagamento;
    }

}
