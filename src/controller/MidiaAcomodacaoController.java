package controller;

import dao.AcomodacaoDAO;
import dao.MidiaAcomodacaoDAO;
import model.Acomodacao;
import model.MidiaAcomodacao;
import model.enums.TipoMidia;
import test.AcomodacaoTest;

import java.util.ArrayList;

public class MidiaAcomodacaoController {
    public String cadastrarMidia(Long idAcomodacao, TipoMidia tipoMidia, String nome) {

        AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();
        Acomodacao acomodacao = acomodacaoDAO.selecionarPorId(idAcomodacao);

        MidiaAcomodacao midiaAcomodacao = new MidiaAcomodacao(acomodacao,tipoMidia,nome);
        MidiaAcomodacaoDAO midiaAcomodacaoDAO = new MidiaAcomodacaoDAO();

        if(idAcomodacao == null){
            return "[ERRO] Id não pode ser nulo";
        }
        if (acomodacaoDAO.selecionarPorId(idAcomodacao) == null) {
            return "[ERRO] Não encontrada. Acomodação não cadastrada!";
        }
        if (nome.trim().equals("")) {
            return "Campo descrição obrigatório!";
        }

        if (midiaAcomodacaoDAO.inserirMidia(midiaAcomodacao)) {
            return "[OK] Midia da acomodação " + acomodacao.getNome() + " cadastrada com sucesso!";
        } else {
            return "[ERRO] Erro desconhecido. Midia da acomodação não cadastrada!";
        }

    }
    public String listarMidia() {
        MidiaAcomodacaoDAO midiaAcomodacaoDAO = new MidiaAcomodacaoDAO();
        ArrayList<MidiaAcomodacao> lista = midiaAcomodacaoDAO.selecionarMidia();

        String conteudo = "";
        for (MidiaAcomodacao midiaAcomodacao : lista) {
            conteudo += midiaAcomodacao + "\n";
        }

        return conteudo;
    }
    public static String alterarMidia(Long id, Acomodacao acomodacao, TipoMidia tipoMidia, String nome) {
        MidiaAcomodacaoDAO midiaAcomodacaoDAO = new MidiaAcomodacaoDAO();
        if (id == null) {
            return "[ERRO] ID não pode ser nulo. Midida da acomodação não alterada!";
        }
        Acomodacao midiaAcomodacaoExistente = midiaAcomodacaoDAO.selecionarMidiaPorId(id);

        if (midiaAcomodacaoExistente == null) {
            return "[ERRO] ID não encontrado. Midia acomodação não alterada!";
        }

//        if (midiaAcomodacaoDAO.selecionarMidiaPorId(id) == null) {
//            return "[ERRO] ID não encontrado. Acomodação não alterada!";
//        }
        if (nome == null || nome.trim().equals("")) {
            return "[ERRO] Campo nome é obrigatório. Acomodação não cadastrada!";
        }

        // Crie uma instância de MidiaAcomodacao com os parâmetros fornecidos
        MidiaAcomodacao midiaAcomodacao = new MidiaAcomodacao(id, acomodacao, tipoMidia, nome);

        if (midiaAcomodacaoDAO.atualizarMidia(midiaAcomodacao)) {
            return "[OK] Acomodação alterada com sucesso!";
        } else {
            return "[ERRO] Erro desconhecido. Acomodação não alterada!";
        }

    }
    public String excluirMidia(Long id) {
        MidiaAcomodacaoDAO midiaAcomodacaoDAO = new MidiaAcomodacaoDAO();

        if (id == null) {
            return "[ERRO] ID não pode ser nulo. Midia não excluída!";
        }
        if (midiaAcomodacaoDAO.selecionarMidiaPorId(id) == null) {
            return "[ERRO] Não encontrada. Midia não excluída!";
        }

        if (midiaAcomodacaoDAO.deletarMidia(id)) {
            return "[OK] Midia excluída com sucesso!";
        } else {
            return "[ERRO] Erro desconhecido. Midia não excluída!";
        }
    }
}