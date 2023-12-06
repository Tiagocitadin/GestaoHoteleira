package test;

import controller.ExemploController;
import dao.connection.ConexaoMySQL;

import java.sql.PreparedStatement;

public class ExemploTest {
    public String testeCadastro(String texto, Integer numero) {
        ExemploController exemploController = new ExemploController();
        String resposta = exemploController.cadastrar(texto, numero);
        return resposta;
    }

    public String testeListagem() {
        ExemploController exemploController = new ExemploController();
        String resposta = exemploController.listar();
        return resposta;
    }

    public String testeAlteracao(Long id, String texto, Integer numero) {
        ExemploController exemploController = new ExemploController();
        String resposta = exemploController.alterar(id, texto, numero);
        return resposta;
    }

    public String testeExclusao() {
        ExemploController exemploController = new ExemploController();
        String resposta = exemploController.excluir(2L);
        return resposta;
    }

}
