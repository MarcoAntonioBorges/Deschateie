package br.com.deschateie.teste;

import br.com.deschateie.beans.Avaliacao;
import br.com.deschateie.beans.Psicologo;
import br.com.deschateie.beans.Usuario;
import br.com.deschateie.bo.AvaliacaoBO;
import br.com.deschateie.excecao.Excecao;

public class TesteAvaliacao {

	public static void main(String[] args) {
		try {
		//	System.out.println(AvaliacaoVoluntarioBO.pesquisarAvaliacao(1).getAll());
		//	System.out.println(new AvaliacaoVoluntarioDAO().consultarAvaliacao(2).getAll());
		
			//System.out.println(AvaliacaoVoluntarioBO.novaAvaliacaoVoluntario(new AvaliacaoVoluntario(99, 11, 4, "32/01/19909", "em analise")));
			//System.out.println(new AvaliacaoVoluntarioDAO().gravarDadosAvaliacao(123, 20, 1, "20/01/1990", "em analise"));
			//System.out.println(AvaliacaoVoluntarioBO.novaAvaliacaoVoluntario(1244, 20, 2, "12/01/1997","Aprovado"));
			AvaliacaoBO.novaAvaliacao(new Avaliacao(55, new Psicologo(20, "SADE", "eget@est.co.uk", "03/01/1971", "ADMIN", "ADMIN", 5, "", "MASCULINO", 5014504, "Tincidunt Vehicula Risus Inc.", "a mi fringilla mi lacinia mattis. Integer eu lacus. Quisque", 34408536, 243.75), new Usuario(17, "CHARISSA", "gravida.non@a.edu", "25/10/1995", "CursuLLP", "JVY03GCM6OR", 6, "", "OUTROS"), "26/09/2018", "ANALISE"));
			System.out.println(AvaliacaoBO.avaliar(new Avaliacao(55, new Psicologo(20, "SADE", "eget@est.co.uk", "03/01/1971", "ADMIN", "ADMIN", 5, "", "MASCULINO", 5014504, "Tincidunt Vehicula Risus Inc.", "a mi fringilla mi lacinia mattis. Integer eu lacus. Quisque", 34408536, 243.75), new Usuario(17, "CHARISSA", "gravida.non@a.edu", "25/10/1995", "CursuLLP", "JVY03GCM6OR", 6, "", "OUTROS"), "26/09/2018", "ANALISE")));
			
//			System.out.println(AvaliacaoVoluntarioBO.pesquisarAvaliacao(1244).getAll());
//			System.out.println(AvaliacaoVoluntarioBO.excluirAvaliacaoVoluntario(1244));
//			
			//System.out.println("---------------------------------");
			//System.out.println(AvaliacaoBO.pesquisarAvaliacao(1).getAll());
			//System.out.println("-------------------------------------");
			
			
			//System.out.println(AvaliacaoVoluntarioBO.pesquisarAvaliacao(0).getAll());
			
			//System.out.println(new AvaliacaoVoluntarioDAO().consultarAvaliacaoUsuario(1).getAll());
			
			
//			System.out.println(AvaliacaoVoluntarioBO.pesquisarAvaliacao(1).getAll());
//			System.out.println("----------------------- S T A T U S ------------------------------");
//			System.out.println(AvaliacaoVoluntarioBO.alteradaDadosAvaliacao(1,"15/09/2018","EM ANALISE"));
//			System.out.println("---------------------------------------------------");
//			System.out.println(AvaliacaoVoluntarioBO.pesquisarAvaliacao(1).getAll());
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
		

	}

}
