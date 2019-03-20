package br.com.deschateie.teste;

import br.com.deschateie.beans.Psicologo;
import br.com.deschateie.bo.PsicologoBO;
import br.com.deschateie.excecao.Excecao;

public class TestePsicologo {

	public static void main(String[] args) {
		try {
			
//			System.out.println(new PsicologoDAO().consultarPsicologo(20).getAll());
//			System.out.println("---------------------------------");
//			System.out.println(PsicologoBO.pesquisarPsicologo(20).getAll());
			System.out.println("---------------------------");
			System.out.println("Psicologo");
			
			
			//depois que que for feito psicologo online executar esse linha de codigo para testar
			//System.out.println(PsicologoBO.excluirPsicologo(44));
			
			System.out.println(PsicologoBO.NovoPsicologo(
					new Psicologo(46, "testepsicologo", "psicologo@teste.com", "12/01/1997", "psicologoFernando", "teste", 4, "c:","masculino", 1434569, "psicologia", "aaaa", 984738372, 200.60),false));
			//System.out.println(PsicologoBO.AlterarDadosPsicologo(new Psicologo(46, "testepsicologo", "psicologo@teste2.com", "12/01/1997", "psicologoFernando23", "teste", 4, "c:","masculino", 654321, "psicologia", "aaaa", 984738372, 200.60)));
	//		System.out.println(PsicologoBO.pesquisarPsicologo(46).getAll());
			

			System.out.println(PsicologoBO.pesquisarPsicologo(46).getAll());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
