package br.com.deschateie.main;

import br.com.deschateie.beans.Avaliacao;
import br.com.deschateie.beans.Psicologo;
import br.com.deschateie.beans.Usuario;
import br.com.deschateie.bo.AvaliacaoBO;
import br.com.deschateie.excecao.Excecao;

public class TesteAvaliacao {

	public static void main(String[] args) {
		try {
			//System.out.println(AvaliacaoBO.pesquisarAvaliacao(64).getAll());
			

			
			
//			System.out.println(AvaliacaoBO.novaAvaliacao(
//					(new Avaliacao(
//							67,
//							new Psicologo(
//									20,
//									null,
//									"asd",
//									"12/01/1997",
//									"asd", 
//									"asd", 
//									6,
//									"c://",
//									"",
//									34535,
//									"asb", 
//									"asd", 
//									5749323, 
//									240
//									), 
//							new Usuario(
//									2,
//									"ASD", 
//									"asd", 
//									"asdad", 
//									"asdad", 
//									"asd", 
//									7,
//									"asd", 
//									"sdfsfd"
//									),
//							"24/09/2018",
//							"APROVADO"))));
//			
			
			int cod = 65;
			System.out.println(AvaliacaoBO.pesquisarAvaliacao(cod).getAll());
			System.out.println("----------------------------------------");
			
			System.out.println(AvaliacaoBO.alterarDadosAvaliacao((
					(new Avaliacao(
							65,
							new Psicologo(), 
							new Usuario(),
							"24/09/2018",
							"REPROVADO")))));
//			System.out.println(AvaliacaoBO.excluirAvaliacaoVoluntario(cod));
//			System.out.println("----------------------------");
//			System.out.println(AvaliacaoBO.pesquisarAvaliacao(cod).getAll());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
