package com.mateuss.financeiro_api.dto;

import com.mateuss.financeiro_api.model.GastoMensal;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoMensalDTO {
    private Integer id;
    private String nome;
    private BigDecimal valor;
    private int diaVencimento;
    private LocalDate dataUltimoPagamento;

    public GastoMensalDTO(Integer id, String nome, BigDecimal valor, int diaVencimento, boolean valorVariavel, LocalDate dataUltimoPagamento) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.diaVencimento = diaVencimento;
        this.dataUltimoPagamento = dataUltimoPagamento;
    }

    public GastoMensalDTO(GastoMensal gastoMensal) {
        this.id = gastoMensal.getId();
        this.nome = gastoMensal.getNomeGasto();
        this.valor = gastoMensal.getValor();
        this.diaVencimento = gastoMensal.getDiaVencimento();
        this.dataUltimoPagamento = getDataUltimoPagamento();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "GastoMensalDTORequest{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", diaVencimento=" + diaVencimento +
                ", dataUltimoPagamento=" + dataUltimoPagamento +
                '}';
    }
}
