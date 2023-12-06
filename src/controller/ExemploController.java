package controller;

import dao.ExemploDAO;
import model.Exemplo;

import java.util.ArrayList;

public class ExemploController {
    public String cadastrar(String texto, Integer numero) {
        if(texto.trim().equals("")) {
            return "[ERRO] Campo texto é obrigatório. Exemplo não cadastrado!";
        }

        Exemplo exemplo = new Exemplo(texto, numero);
        ExemploDAO exemploDAO = new ExemploDAO();

        if(exemploDAO.inserir(exemplo)) {
            return "[OK] Exemplo cadastrado com sucesso!";
        } else {
            return "[ERRO] Erro desconhecido. Exemplo não cadastrado!";
        }
    }

    public String listar() {
        ExemploDAO exemploDAO = new ExemploDAO();
        ArrayList<Exemplo> lista = exemploDAO.selecionar();

        String conteudo = "";
        for (Exemplo exemplo : lista) {
            conteudo += exemplo + "\n";
        }

        return conteudo;
    }

    public String alterar(Long id, String texto, Integer numero) {
        Exemplo exemplo = new Exemplo(id, texto, numero);
        ExemploDAO exemploDAO = new ExemploDAO();
        if(exemploDAO.atualizar(exemplo)) {
            return "[OK] Exemplo alterado com sucesso!";
        } else {
            return "[ERRO] Erro desconhecido. Exemplo não alterado!";
        }
    }

    public String excluir(Long id) {
        ExemploDAO exemploDAO = new ExemploDAO();
        if(exemploDAO.deletar(id)) {
            return "[OK] Exemplo excluído com sucesso!";
        } else {
            return "[ERRO] Erro desconhecido. Exemplo não excluído!";
        }
    }
}
