package dao;

import dao.connection.ConexaoMySQL;
import model.Exemplo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExemploDAO {
    public Boolean inserir(Exemplo exemplo) {
        try {
            String sql = "INSERT INTO exemplo (texto, numero) VALUES (?, ?)";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setString(1, exemplo.getTexto());
            preparacao.setInt(2, exemplo.getNumero());
            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Exemplo> selecionar() {
        try {
            String sql = "SELECT * FROM exemplo ORDER BY id";
            Statement stmt = ConexaoMySQL.get().createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            ArrayList<Exemplo> lista = new ArrayList<>();
            while(resultado.next()) {
                Exemplo exemplo = new Exemplo(
                    resultado.getLong("id"),
                    resultado.getString("texto"),
                    resultado.getInt("numero")
                );
                lista.add(exemplo);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean atualizar(Exemplo exemplo) {
        try {
            String sql = "UPDATE exemplo SET texto = ?, numero = ? WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setString(1, exemplo.getTexto());
            preparacao.setInt(2, exemplo.getNumero());
            preparacao.setLong(3, exemplo.getId());
            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deletar(Long id) {
        try {
            String sql = "DELETE FROM exemplo WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setLong(1, id);
            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
