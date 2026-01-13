package com.mateuss.financeiro_api.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InfoFinanceirasUsuario {
    private Usuario usuario;
    private BigDecimal orcamento;
    private BigDecimal despesas;
    private ArrayList<Transacao> TransacoesUsuario;

    public InfoFinanceirasUsuario(BigDecimal orcamento, BigDecimal despesas, ArrayList<Transacao> transacoesUsuario, Usuario usuario) {
        this.orcamento = orcamento;
        this.despesas = despesas;
        TransacoesUsuario = transacoesUsuario;
        this.usuario = usuario;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public BigDecimal getDespesas() {
        return despesas;
    }

    public void setDespesas(BigDecimal despesas) {
        this.despesas = despesas;
    }

    public ArrayList<Transacao> getTransacoesUsuario() {
        return TransacoesUsuario;
    }

    public void setTransacoesUsuario(ArrayList<Transacao> transacoesUsuario) {
        TransacoesUsuario = transacoesUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "InfoFinanceirasUsuario{" +
                "orcamento=" + orcamento +
                ", despesas=" + despesas +
                ", TransacoesUsuario=" + TransacoesUsuario +
                ", usuario=" + usuario +
                '}';
    }
}