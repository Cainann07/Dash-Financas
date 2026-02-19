package com.mateuss.financeiro_api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private String categoria;
    private String descricao;
    private LocalDate data;
    private BigDecimal valor;

    @Enumerated(EnumType.STRING) // Com isso o Java só enviará para o banco de dados o valor da categoria se atender a um dos valores que o Enum de 'TipoTransacao' fornece.
    private TipoTransacao tipo;

    public Transacao(String categoria, String descricao, LocalDate data, BigDecimal valor) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", valor=" + valor +
                '}';
    }
}
