package model;

import java.util.Objects;

public class Exemplo {
    private Long id;
    private String texto;
    private Integer numero;

    public Exemplo() {}
    public Exemplo(Long id, String texto, Integer numero) {
        this.id = id;
        this.texto = texto;
        this.numero = numero;
    }
    public Exemplo(String texto, Integer numero) {
        this.texto = texto;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "ID " + id +
            " | Texto: " + texto +
            " | Número: " + numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exemplo exemplo = (Exemplo) o;

        return Objects.equals(id, exemplo.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
