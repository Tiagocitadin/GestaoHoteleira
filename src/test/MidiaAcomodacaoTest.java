package test;

import controller.AcomodacaoController;
import controller.MidiaAcomodacaoController;
import model.enums.TipoMidia;

public class MidiaAcomodacaoTest {

    public String midiaAcomodacaoCadastro(Long idAcomodacao, TipoMidia tipoMidia, String nome) {
        MidiaAcomodacaoController midiaAcomodacaoController = new MidiaAcomodacaoController();
        String resposta = midiaAcomodacaoController.cadastrarMidia(idAcomodacao, tipoMidia, nome);
        return resposta;
    }
    public String midiaAcomodacaoListagem() {
        MidiaAcomodacaoController midiaAcomodacaoController = new MidiaAcomodacaoController();
        String resposta = midiaAcomodacaoController.listarMidia();
        return resposta;
    }

    public String midiaAcomodacaoAlteracao(Long id, AcomodacaoTest acomodacao, TipoMidia tipoMidia, String nome) {
        MidiaAcomodacaoController midiaAcomodacaoController = new MidiaAcomodacaoController();
        String resposta = MidiaAcomodacaoController.alterarMidia(id, acomodacao, tipoMidia, nome);
        return resposta;
    }
    public String midiaAcomodacaoExclusao(Long id) {
        MidiaAcomodacaoController midiaAcomodacaoController = new MidiaAcomodacaoController();
        String resposta = midiaAcomodacaoController.excluirMidia(id);
        return resposta;
    }
}
