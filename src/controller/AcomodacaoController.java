package controller;

import dao.AcomodacaoDAO;
import model.Acomodacao;

import java.util.ArrayList;

public class AcomodacaoController {


    public String cadastrar(String nome, Double valorDiaria, Integer limiteHospedes, String descricao) {
        if (nome == null || nome.trim().equals("")) {
            return "[ERRO] Campo nome é obrigatório. Acomodação não cadastrada!";
        }
        if (valorDiaria <= 0.00) {
            return "[ERRO] Valor não pode ser 0.00";
        }
        if (limiteHospedes > 4)
            return "[ERRO] Excedeu limite de hóspedes";

        if (descricao == null || descricao.trim().equals("")) {
            return "[ERRO] Campo descrição obrigatório. Acomodação não cadastrada!";
        }

        Acomodacao acomodacao = new Acomodacao(nome, valorDiaria, limiteHospedes, descricao);
        AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();

        if (acomodacaoDAO.inserir(acomodacao)) {
            return "[OK] Acomodação cadastrada com sucesso!";
        } else {
            return "[ERRO] Erro desconhecido. Acomodação não cadastrada!";
        }
    }

    public String listar() {
        AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();
        ArrayList<Acomodacao> lista = acomodacaoDAO.selecionar();

        String conteudo = "";
        for (Acomodacao acomodacao : lista) {
            conteudo += acomodacao + "\n";
        }

        return conteudo;
    }

    public String alterar(Long id, String nome, Double valorDiaria, Integer limiteHospedes, String descricao) {
        AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();
        if (id == null) {
            return "[ERRO] ID não pode ser nulo. Acomodação não alterada!";
        }
        if (acomodacaoDAO.selecionarPorId(id) == null) {
            return "[ERRO] ID não encontrado. Acomodação não alterada!";
        }
        if (nome == null || nome.trim().equals("")) {
            return "[ERRO] Campo nome é obrigatório. Acomodação não cadastrada!";
        }

        Acomodacao acomodacao = new Acomodacao(id, nome, valorDiaria, limiteHospedes, descricao);
        if (acomodacaoDAO.atualizar(acomodacao)) {
            return "[OK] Acomodação alterada com sucesso!";
        } else {
            return "[ERRO] Erro desconhecido. Acomodação não alterada!";
        }
    }

    public String excluir(Long id) {
        AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();

        if (id == null) {
            return "[ERRO] ID não pode ser nulo. Acomodação não excluída!";
        }
        if (acomodacaoDAO.selecionarPorId(id) == null) {
            return "[ERRO] Não encontrada. Acomodação não excluída!";
        }

        if (acomodacaoDAO.deletar(id)) {
            return "[OK] Acomodação excluída com sucesso!";
        } else {
            return "[ERRO] Erro desconhecido. Acomodacao não excluída!";
        }
    }


}
