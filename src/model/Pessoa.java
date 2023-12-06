package model;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Pessoa {
    // Atributos
    private Long id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String documento;
    private String pais;
    private String estado;
    private String cidade;

    // Construtores
    public Pessoa() {}
    public Pessoa(String nomeCompleto, LocalDate dataNascimento, String documento, String pais, String estado, String cidade) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
    }

    // Gets e Sets

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimentoFormatoBR() {
        if (dataNascimento == null) return null;
        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formatoBR);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // To String
    @Override
    public String toString() {
        return "ID:" + id +
            " | Nome completo: " + nomeCompleto +
            " | Data de nascimento: " + this.getDataNascimentoFormatoBR() +
            " | Documento: " + documento +
            " | País: " + pais +
            " | Estado: " + estado +
            " | Cidade: " + cidade;
    }

    // Hash e equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
