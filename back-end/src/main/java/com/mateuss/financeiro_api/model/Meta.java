package com.mateuss.financeiro_api.model;

import jakarta.persistence.*;

@Entity
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private String nome;
    private double saldoAtual;
    private double valorAlvo;
    private String categoria;

    public Meta(String nome, double saldoAtual, double valorAlvo, String categoria) {
        this.nome = nome;
        this.saldoAtual = saldoAtual;
        this.valorAlvo = valorAlvo;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public double getValorAlvo() {
        return valorAlvo;
    }

    public void setValorAlvo(double valorAlvo) {
        this.valorAlvo = valorAlvo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "nome='" + nome + '\'' +
                ", saldo=" + saldoAtual +
                ", metaDinheiro=" + valorAlvo +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
