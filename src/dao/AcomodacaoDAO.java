package dao;

import dao.connection.ConexaoMySQL;
import model.Acomodacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AcomodacaoDAO {
    public Boolean inserir(Acomodacao acomodacao) {
        try {
            String sql = "INSERT INTO acomodacao (nome, valor_diaria, limite_hospedes, descricao) VALUES (?, ?, ?, ?)";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setString(1, acomodacao.getNome());
            preparacao.setDouble(2, acomodacao.getValorDiaria());
            preparacao.setInt(3, acomodacao.getLimiteHospedes());
            preparacao.setString(4, acomodacao.getDescricao());
            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Acomodacao> selecionar() {
        try {
            String sql = "SELECT * FROM acomodacao ORDER BY id";
            Statement stmt = ConexaoMySQL.get().createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            ArrayList<Acomodacao> lista = new ArrayList<>();
            while(resultado.next()) {
                Acomodacao acomodacao = new Acomodacao(
                        resultado.getLong("id"),
                        resultado.getString("nome"),
                        resultado.getDouble("valor_diaria"),
                        resultado.getInt("limite_hospedes"),
                        resultado.getString("descricao")
                );


                lista.add(acomodacao);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean atualizar(Acomodacao acomodacao) {
        try {
            String sql = "UPDATE acomodacao SET nome = ?, valor_diaria = ?, limite_hospedes = ?, descricao = ?  WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setString(1, acomodacao.getNome());
            preparacao.setDouble(2, acomodacao.getValorDiaria());
            preparacao.setInt(3, acomodacao.getLimiteHospedes());
            preparacao.setString(4, acomodacao.getDescricao());
            preparacao.setLong(5, acomodacao.getId());
            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deletar(Long id) {

        try {
            String sqlReserva = "DELETE FROM reserva WHERE id_acomodacao = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sqlReserva);
            preparacao.setLong(1, id);
            int contLinhasAfetadas = preparacao.executeUpdate();
            if (contLinhasAfetadas > 0) {
                return true;
            }

            String sqlPacote = "DELETE FROM pacote WHERE id_acomodacao = ?";
            preparacao = ConexaoMySQL.get().prepareStatement(sqlPacote);
            preparacao.setLong(1, id);
            contLinhasAfetadas = preparacao.executeUpdate();
            if (contLinhasAfetadas > 0) {
                return true;
            }

            String sqlMidiaAcomodacao = "DELETE FROM midia_acomodacao WHERE id_acomodacao = ?";
            preparacao = ConexaoMySQL.get().prepareStatement(sqlMidiaAcomodacao);
            preparacao.setLong(1, id);
            contLinhasAfetadas = preparacao.executeUpdate();
            if (contLinhasAfetadas > 0) {
                return true;
            }

            String sqlAcomodacao = "DELETE FROM acomodacao WHERE id = ?";
            preparacao = ConexaoMySQL.get().prepareStatement(sqlAcomodacao);
            preparacao.setLong(1, id);
            contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;


        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Acomodacao selecionarPorId(Long id) {
        try {
            String sql = "SELECT * FROM acomodacao WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setLong(1, id);
            ResultSet resultado = preparacao.executeQuery();

            if(resultado.next()) {
                Acomodacao acomodacao = new Acomodacao(
                        resultado.getLong("id"),
                        resultado.getString("nome"),
                        resultado.getDouble("valor_diaria"),
                        resultado.getInt("limite_hospedes"),
                        resultado.getString("descricao")
                );
                return acomodacao;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
