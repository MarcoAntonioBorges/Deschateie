package br.com.deschateie.teste;


import br.com.deschateie.excecao.Excecao;

public class TesteAgendamento {

	public static void main(String[] args) {

		try {
			
//			System.out.println(AgendamentoBO.pesquisarAgendamento(104).getAll());
//			System.out.println("------------------ S T A T U S-----------------------");
//			System.out.println(AgendamentoBO.exluirAgendamento(104));
//			System.out.println("------------------------------------------------");
//			System.out.println(AgendamentoBO.pesquisarAgendamento(104).getAll());
//			
//			
//			System.out.println(AgendamentoBO.AlterarDadosAgendamento(100,"30/12/2018"));
//			System.out.println("----------------------------------------------");
//			System.out.println(AgendamentoBO.pesquisarAgendamento(100).getAll());
//			System.out.println("------------------ S T A T U S-----------------------");
//			System.out.println(AgendamentoBO.exluirAgendamento(100));
//			System.out.println("---------------------------------------");
//			System.out.println(AgendamentoBO.pesquisarAgendamento(100).getAll());
			
			
			
		//	System.out.println(AgendamentoBO.novoAgendamento(15,20,4,"26/09/2018"));
			
		//	System.out.println(AgendamentoBO.pesquisarAgendamento(15).getAll());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
