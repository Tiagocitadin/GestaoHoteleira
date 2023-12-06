package model;

import util.GeralUtil;

import java.text.DecimalFormat;
import java.util.Objects;

public class Pacote {
    // Atributos
    private Long id;
    private String nome;
    private Acomodacao acomodacao;
    private Integer qtdDiarias;
    private Double valorTotal;

    // Construtores

    public Pacote() {}

    public Pacote(String nome, Acomodacao acomodacao, Integer qtdDiarias, Double valorTotal) {
        this.nome = nome;
        this.acomodacao = acomodacao;
        this.qtdDiarias = qtdDiarias;
        this.valorTotal = valorTotal;
    }

    // Gets e Sets

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

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public Integer getQtdDiarias() {
        return qtdDiarias;
    }

    public void setQtdDiarias(Integer qtdDiarias) {
        this.qtdDiarias = qtdDiarias;
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
            " | Nome: " + nome +
            " | Acomodação: " + acomodacao.getNome() +
            " | Qtd. diárias " + qtdDiarias +
            " | Valor total: " + GeralUtil.formatarValorMonetario(valorTotal);
    }

    // Hash e Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pacote pacote = (Pacote) o;

        return Objects.equals(id, pacote.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
