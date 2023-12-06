package model;

import util.GeralUtil;

import java.text.DecimalFormat;
import java.util.Objects;

public class Acomodacao {
    // Atributos
    private Long id;
    private String nome;
    private Double valorDiaria;
    private Integer limiteHospedes;
    private String descricao;

    // Construtores

    public Acomodacao() {}

    public Acomodacao(Long id, String nome, Double valorDiaria, Integer limiteHospedes, String descricao) {
        this.id = id;
        this.nome = nome;
        this.valorDiaria = valorDiaria;
        this.limiteHospedes = limiteHospedes;
        this.descricao = descricao;
    }
    public Acomodacao(String nome, Double valorDiaria, Integer limiteHospedes, String descricao) {
        this.nome = nome;
        this.valorDiaria = valorDiaria;
        this.limiteHospedes = limiteHospedes;
        this.descricao = descricao;
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

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Integer getLimiteHospedes() {
        return limiteHospedes;
    }

    public void setLimiteHospedes(Integer limiteHospedes) {
        this.limiteHospedes = limiteHospedes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // To String
    @Override
    public String toString() {
        return "ID: " + id +
            "| Nome: " + nome +
            " | Valor da diária: " + GeralUtil.formatarValorMonetario(valorDiaria) +
            " | Limite de hóspedes: " + limiteHospedes +
            " | Descrição: " + descricao;
    }

    // Hash e Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Acomodacao that = (Acomodacao) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
