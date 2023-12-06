package model;

import model.enums.TipoMidia;

import java.util.Objects;

public class MidiaAcomodacao {
    // Atributos
    private Long id;
    private Acomodacao acomodacao;
    private TipoMidia tipo;
    private String nome;

    // Construtores

    public MidiaAcomodacao() {}

    public MidiaAcomodacao(Acomodacao acomodacao, TipoMidia tipo, String nome) {
        this.acomodacao = acomodacao;
        this.tipo = tipo;
        this.nome = nome;
    }

    public MidiaAcomodacao(Long id, Acomodacao acomodacao, TipoMidia tipo, String nome) {
        this.id = id;
        this.acomodacao = acomodacao;
        this.tipo = tipo;
        this.nome = nome;
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

    public TipoMidia getTipo() {
        return tipo;
    }

    public void setTipo(TipoMidia tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // To String

    @Override
    public String toString() {
        return "ID: " + id +
            " | Acomodação: " + acomodacao.getNome() +
            " | Tipo: " + tipo +
            " | Nome: " + nome;
    }

    // Hash e Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MidiaAcomodacao that = (MidiaAcomodacao) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
