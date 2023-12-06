package model;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente extends Pessoa {
    // Atributos
    private Long id;
    private Boolean fidelidade;
    private String observacao;

    // Construtores

    public Cliente() {}

    public Cliente(
            String nomeCompleto,
            LocalDate dataNascimento,
            String documento, String pais,
            String estado, String cidade,
            Boolean fidelidade,
            String observacao
    ) {
        super(nomeCompleto, dataNascimento, documento, pais, estado, cidade);
        this.fidelidade = fidelidade;
        this.observacao = observacao;
    }

    // Gets e Sets

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(Boolean fidelidade) {
        this.fidelidade = fidelidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    // To String
    @Override
    public String toString() {
        return "ID: " + id +
            " | Nome completo: " + super.getNomeCompleto() +
            " | Data de nascimento: " + super.getDataNascimentoFormatoBR() +
            " | Documento: " + super.getDocumento() +
            " | País: " + super.getPais() +
            " | Estado: " + super.getEstado() +
            " | Cidade: " + super.getCidade() +
            " | Fidelidade: " + fidelidade +
            " | Observacao: " + observacao;
    }


    // Hash e Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cliente cliente = (Cliente) o;

        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
