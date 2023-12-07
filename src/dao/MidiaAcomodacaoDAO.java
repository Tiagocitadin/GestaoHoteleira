package dao;

import dao.connection.ConexaoMySQL;
import model.Acomodacao;
import model.MidiaAcomodacao;
import model.enums.TipoMidia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MidiaAcomodacaoDAO {

    public Boolean inserirMidia(MidiaAcomodacao midiaAcomodacao) {

        try {
            String sql = "INSERT INTO midia_acomodacao (id_acomodacao, tipo, nome) VALUES (?, ?, ?)";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setLong(1, midiaAcomodacao.getAcomodacao().getId());
            preparacao.setObject(2, midiaAcomodacao.getTipo().toString());
            preparacao.setString(3, midiaAcomodacao.getNome());

            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<MidiaAcomodacao> selecionarMidia() {
        try {
            String sql = "SELECT * FROM midia_acomodacao ORDER BY id";
            Statement stmt = ConexaoMySQL.get().createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();

            ArrayList<MidiaAcomodacao> lista = new ArrayList<>();
            while(resultado.next()) {
                Acomodacao acomodacao = acomodacaoDAO.selecionarPorId(resultado.getLong("id_acomodacao"));


                MidiaAcomodacao midiaAcomodacao = new MidiaAcomodacao(
                        resultado.getLong("id"),
                        acomodacao,
                        TipoMidia.fromString(resultado.getString("tipo")),
                        resultado.getString("nome")
                );

                lista.add(midiaAcomodacao);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean atualizarMidia(MidiaAcomodacao midiaAcomodacao) {
        try {
            if (midiaAcomodacao == null || midiaAcomodacao.getAcomodacao() == null || midiaAcomodacao.getAcomodacao().getId() == null) {
                // Adicione verificações para evitar NullPointerException
                System.out.println("[ERRO] Objeto MidiaAcomodacao ou ID da Acomodacao é nulo. Midia da acomodação não alterada!");
                return false;
            }

            String sql = "UPDATE midia_acomodacao SET id_acomodacao = ?, tipo = ?, nome = ? WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setLong(1, midiaAcomodacao.getAcomodacao().getId());
            preparacao.setString(2, String.valueOf(midiaAcomodacao.getTipo()));
            preparacao.setString(3, midiaAcomodacao.getNome());
            preparacao.setLong(4, midiaAcomodacao.getId());
            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Acomodacao selecionarMidiaPorId(Long id) {
        try {
            String sql = "SELECT * FROM midia_acomodacao WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setLong(1, id);
            ResultSet resultado = preparacao.executeQuery();

            if(resultado.next()) {  // Verifica se há pelo menos uma linha no conjunto de resultados
                AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();
                Acomodacao acomodacao = acomodacaoDAO.selecionarPorId(resultado.getLong("id_acomodacao"));

                MidiaAcomodacao midiaAcomodacao = new MidiaAcomodacao(
                        resultado.getLong("id"),
                        acomodacao,
                        TipoMidia.fromString(resultado.getString("tipo")),
                        resultado.getString("nome")
                );

                return midiaAcomodacao.getAcomodacao();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

public Boolean deletarMidia(Long id) {
    try {
        String sql = "DELETE FROM midia_acomodacao WHERE id = ?";
        PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
        preparacao.setLong(1, id);
        int contLinhasAfetadas = preparacao.executeUpdate();
        return contLinhasAfetadas > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}