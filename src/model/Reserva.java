package model;

import util.GeralUtil;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reserva {
    // Atributos
    private Long id;
    private Acomodacao acomodacao;
    private Cliente cliente;
    private Integer qtdHospedes;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double valorTotal;

    // Construtores

    public Reserva() {}

    public Reserva(Acomodacao acomodacao, Cliente cliente, Integer qtdHospedes, LocalDate dataInicio, LocalDate dataFim, Double valorTotal) {
        this.acomodacao = acomodacao;
        this.cliente = cliente;
        this.qtdHospedes = qtdHospedes;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
    }

    // Gets e Sets

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getQtdHospedes() {
        return qtdHospedes;
    }

    public void setQtdHospedes(Integer qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }


    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // To String
    @Override
    public String toString() {
        return "ID: " + id +
            " | Acomodação: " + acomodacao.getNome() +
            " | Cliente: " + cliente.getNomeCompleto() +
            " | Qtd. de hóspedes: " + qtdHospedes +
            " | Data início: " + GeralUtil.formatarDataBr(dataInicio) +
            " | Data fim: " + GeralUtil.formatarDataBr(dataFim) +
            " | Valor total: " +GeralUtil.formatarValorMonetario(valorTotal);
    }

    // Hash e Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reserva reserva = (Reserva) o;

        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
