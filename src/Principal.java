import controller.ExemploController;
import controller.MidiaAcomodacaoController;
import model.*;
import model.enums.TipoMidia;
import test.AcomodacaoTest;
import test.ExemploTest;
import test.MidiaAcomodacaoTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {


        System.out.println("Protótipo de Aplicação para Gestão Hoteleira");

    AcomodacaoTest acomodacaoTest = new AcomodacaoTest();
      // System.out.println(acomodacaoTest.acomodacaoCadastro("Teste", 0.00, 4, "Pequeno"));
       // System.out.println(acomodacaoTest.acomodacaoCadastro("Teste", 1.00, 4, " "));
       // System.out.println(acomodacaoTest.acomodacaoCadastro("Teste", 5.00, 5, "Pequeno"));
        // System.out.println(acomodacaoTest.acomodacaoCadastro("Chalezinho", 5.00, 2, ""));
        // System.out.println(acomodacaoTest.acomodacaoCadastro("Chalezinho", 5.00, 2, "  "));

        //System.out.println(acomodacaoTest.acomodacaoAlteracao(5L,"bh",500.00,5,"agora"));
        System.out.println(acomodacaoTest.acomodacaoExclusao(9L));
        System.out.println(acomodacaoTest.acomodacaoListagem());

       //System.out.println(acomodacaoTest.acomodacaoExclusao(L));
        //MidiaAcomodacaoTest midiaAcomodacaoTest = new MidiaAcomodacaoTest();
        //System.out.println(midiaAcomodacaoTest.midiaAcomodacaoCadastro(9L, TipoMidia.IMAGEM, " Piscina"));
       //System.out.println(midiaAcomodacaoTest.midiaAcomodacaoListagem());
        //System.out.println(midiaAcomodacaoTest.midiaAcomodacaoAlteracao(3L,MidiaAcomodacao, TipoMidia.VIDEO, "alterou"));
        //System.out.println(midiaAcomodacaoTest.midiaAcomodacaoExclusao(8L));
    }

}
