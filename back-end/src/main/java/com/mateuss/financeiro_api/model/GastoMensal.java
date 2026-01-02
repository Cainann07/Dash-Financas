package com.mateuss.financeiro_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

@Entity
public class GastoMensal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da conta é obrigatório")
    private String nome;

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valor;

    @Min(value = 1, message = "O dia deve ser pelo menos 1")
    @Max(value = 31, message = "O dia deve ser no máximo 31")
    private int diaVencimento;

    private boolean valorVariavel;

    private LocalDate dataUltimoPagamento;

    public boolean isPago(){
        if (dataUltimoPagamento == null){
            return false;
        }

        YearMonth mesPagamento = YearMonth.from(dataUltimoPagamento);
        YearMonth mesAtual = YearMonth.now();

        return mesPagamento.equals(mesAtual);
    }

    public GastoMensal(Long id, String nome, BigDecimal valor, int diaVencimento, LocalDate dataUltimoPagamento) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.diaVencimento = diaVencimento;
        this.dataUltimoPagamento = dataUltimoPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "GastoMensal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", diaVencimento=" + diaVencimento +
                ", dataUltimoPagamento=" + dataUltimoPagamento +
                '}';
    }
}
