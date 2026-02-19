package com.mateuss.financeiro_api.model;


import com.mateuss.financeiro_api.dto.GastoMensalDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

@Entity
public class GastoMensal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotBlank(message = "O nome dessa conta é obrigatório")
    private String nomeGasto;

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

    public GastoMensal(){}

    public GastoMensal(Usuario usuario, GastoMensalDTO gastoMensalDTO) {
        this.usuario = usuario;
        this.nomeGasto = gastoMensalDTO.getNome();
        this.valor = gastoMensalDTO.getValor();
        this.diaVencimento = gastoMensalDTO.getDiaVencimento();
        this.dataUltimoPagamento = gastoMensalDTO.getDataUltimoPagamento();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeGasto() {
        return nomeGasto;
    }

    public void setNomeGasto(String nomeGasto) {
        this.nomeGasto = nomeGasto;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "GastoMensal{" +
                "id=" + id +
                ", nome='" + nomeGasto + '\'' +
                ", valor=" + valor +
                ", diaVencimento=" + diaVencimento +
                ", dataUltimoPagamento=" + dataUltimoPagamento +
                '}';
    }
}
