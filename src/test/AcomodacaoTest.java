package test;

import controller.AcomodacaoController;
import controller.ExemploController;
import model.Acomodacao;

public class AcomodacaoTest extends Acomodacao {
    public String acomodacaoCadastro(String nome, Double valorDiaria, Integer limiteHospedes, String descricao) {
        AcomodacaoController acomodacaoController= new AcomodacaoController();
        String resposta = acomodacaoController.cadastrar(nome, valorDiaria, limiteHospedes, descricao);
        return resposta;
    }

    public String acomodacaoListagem() {
        AcomodacaoController acomodacaoController = new AcomodacaoController();
        String resposta = acomodacaoController.listar();
        return resposta;
    }

    public String acomodacaoAlteracao(Long id, String nome, Double valorDiaria, Integer limiteHospedes, String descricao) {
        AcomodacaoController acomodacaoController = new AcomodacaoController();
        String resposta = acomodacaoController.alterar(id, nome, valorDiaria, limiteHospedes, descricao);
        return resposta;
    }
// Arrumar id do excluir
    public String acomodacaoExclusao(Long id) {
        AcomodacaoController acomodacaoController = new AcomodacaoController();
        String resposta = acomodacaoController.excluir(id);
        return resposta;
    }

}
