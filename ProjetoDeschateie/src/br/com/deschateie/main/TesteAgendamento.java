package br.com.deschateie.main;

import br.com.deschateie.beans.Agendamento;
import br.com.deschateie.beans.Psicologo;
import br.com.deschateie.beans.Usuario;
import br.com.deschateie.bo.AgendamentoBO;
import br.com.deschateie.excecao.Excecao;

public class TesteAgendamento {

	public static void main(String[] args) {
		
		try {
//			System.out.println(AgendamentoBO.pesquisarAgendamento(100).getAll());
//			System.out.println("---------------------------------");
//			System.out.println(AgendamentoBO.exluirAgendamento(100));
//			System.out.println(AgendamentoBO.pesquisarAgendamento(100).getAll());
////			
//			System.out.println(AgendamentoBO.AlterarDadosAgendamento(
//					new Agendamento(104, 
//							new Psicologo(1385,
//									"asd",
//									"324",
//									"12/01/2018", 
//									"aa", 
//									"a", 
//									1,
//									"c:", 
//									"masculino", 
//									9483,
//									"osd",
//									"asd", 
//									21454533,
//									473.3),
//							new Usuario(
//									3,
//									"asd",
//									"asdad", 
//									"12/01/1997",
//									"asdas",
//									"sdfsaf",
//									0,
//									"c://ss",
//									"feminino")
//							, "12/01/2018")));
			
			
			

			System.out.println(AgendamentoBO.novoAgendamento(
					new Agendamento(100, 
							new Psicologo(13,
									"asd",
									"324",
									"12/01/2018", 
									"aa", 
									"a", 
									1,
									"c:", 
									"masculino", 
									9483,
									"osd",
									"asd", 
									21454533,
									473.3),
							new Usuario(
									9,
									"asd",
									"asdad", 
									"12/01/1997",
									"asdas",
									"sdfsaf",
									0,
									"c://ss",
									"feminino")
							, "8/01/2018")));
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
		
	}

}
