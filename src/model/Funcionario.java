package model;

import util.GeralUtil;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa {
    // Atributos
    private Long id;
    private String cargo;
    private Double salario;

    // Construtores

    public Funcionario() {}

    public Funcionario
    (
        String nomeCompleto,
        LocalDate dataNascimento,
        String documento,
        String pais,
        String estado,
        String cidade,
        String cargo,
        Double salario
    ) {
        super(nomeCompleto, dataNascimento, documento, pais, estado, cidade);
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
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
            " | Cargo: " + cargo +
            " | Salário: " + GeralUtil.formatarValorMonetario(salario);
    }

    // Hash e Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Funcionario that = (Funcionario) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
