package com.mateuss.financeiro_api.dto;

import com.mateuss.financeiro_api.model.TipoTransacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoDTO {

    private String categoria;
    private String descricao;
    private LocalDate data;
    private BigDecimal valor;
    private TipoTransacao tipo;

    public TransacaoDTO(TipoTransacao tipo, BigDecimal valor, LocalDate data, String descricao, String categoria) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TransacaoDTOResponse{" +
                "categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", valor=" + valor +
                ", tipo=" + tipo +
                '}';
    }
}
