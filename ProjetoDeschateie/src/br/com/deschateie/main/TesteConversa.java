package br.com.deschateie.main;

import br.com.deschateie.bo.ConsultaBO;
import br.com.deschateie.dao.ConsultaDAO;
import br.com.deschateie.excecao.Excecao;

public class TesteConversa {
	
	public static void main(String[] args) {
		try {
			
			
//		System.out.println(ConversaBO.pesquisarConversa(9).getAll());
//		System.out.println("----------------3----------------");
//		//vai dar erro por ser chave primaria em outra tabela, o ideia é verificar se existe na outra tabela, exlcuir da outra tabela
//		// e depois excluir essa tabela
//		System.out.println(ConversaBO.exluirConversa(9));
//		System.out.println("--------------- S T A T U S -------------------");
//		System.out.println(ConversaBO.pesquisarConversa(9));
//	System.out.println(ConversaBO.novaConversa(new Conversa(123,"18/09/2018-20:20",12,"historico","18/09/2018-20:19",
//			new Voluntario(12, "voluntarioTeste", "voluntario@voluntario.com.br", "12/01/1997", "voluntArio", "voluntario", 2, "c:asd", "Masculino", "xxxxx-x", 9483485384l, "psicologia", "manha", "teste", 8483932))));
	
		//System.out.println(DataBO.validarData("12/12/2017"));
	//	System.out.println(DataBO.comparaDatas("12/04/2000-12:22", "12/04/2000-12:"));
		
		//	System.out.println(DataBO.converterFormatoData("2019-01-28 12:00"));
	//System.out.println(DataBO.converterFormatoData(AgendamentoBO.pesquisarAgendamento(103).getDataAgendamento()));
//	
//			System.out.println(PacienteBO.novoPaciente(new Paciente(3, "475id", "sdfljafs@asljdas.com.br", "12/01/1997",
//					"asjlsdfa", "asdflkjafs", 0, "caslkj", "asdfs", "039302", 982340993l, "historico", 2),true));
//			
			System.out.println(ConsultaBO.excluirConsulta(34));
			
//		System.out.println(ConversaBO.novaConversa(new Conversa(34, "19/09/2018-20:20", 7, "historico", "19/09/2018-20:23",
//			new Voluntario(21, "JUSTINA", "penatibus@diamlorem.com", "25/09/1977", "SemNulla", "VNB75DVV4ME", 5, "caminhoFoto",
//					"masculino", "49266119", 49266119l, "Et PC", "manha",
//					"consectetuer adipiscing elit. Aliquam auctor, velit eget", 43309727206l))));	
			
			
//			System.out.println(ConversaBO.pesquisarConversa(37).getAll());
//			System.out.println("--------------- S T A T U S ----------------");
//			System.out.println(ConversaBO.alterarDadosConversa(new Conversa(37, "19/09/2018-03:20", 7, "Histórico paciente fianl", "10/09/2018-00:22",
//					new Voluntario(21, "JUSTINA", "penatibus@diamlorem.com", "25/09/1977", "SemNulla", "VNB75DVV4ME", 5, "caminhoFoto",
//							"masculino", "49266119", 49266119l, "Et PC", "manha",
//							"consectetuer adipiscing elit. Aliquam auctor, velit eget", 43309727206l))));	
//			System.out.println("------------------------------------------");
//			System.out.println(ConversaBO.pesquisarConversa(37).getAll());
//			
		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e)); 
		}
		
	}
}
