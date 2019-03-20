package br.com.deschateie.teste;

import br.com.deschateie.beans.Paciente;
import br.com.deschateie.bo.PacienteBO;
import br.com.deschateie.dao.PacienteDAO;
import br.com.deschateie.excecao.Excecao;

public class TestePaciente {

	public static void main(String[] args) {
		
		try {
			
			//System.out.println(new PacienteDAO().AlteraDadosPaciente((new Paciente(32, "donan33fer23", "donanfe1232r@hotmail.com","12/01/1997", "don123an33fer2", "do33nanfer", 4, "D://aa","masculino", 32, 9450499, 9999999, "legal",5))));
			//System.out.println(UsuarioBO.novoUsuario(new Usuario(36, "Zé bunitinho", "zeBunitinho@zezihno.com", "03/12/1940", "zezinho", "zezeze", 1, " ", "masculino")));
			//System.out.println( new PacienteDAO().excluirPaciente(32));
			//System.out.println(UsuarioBO.excluirUsuario(32));
			//System.out.println(new  UsuarioDAO().consultarCodUsuario(30).getAll());
			
			//System.out.println(new PacienteDAO().consultarPaciente(10).getAll());
			
		//	System.out.println(PacienteBO.consutlarPaciente(30));
			//System.out.println(PacienteBO.novoPaciente(new Paciente(36, "Zé bunitinho", "zeBunitinho@zezihno.com", "3/12/1940", "zezinhao", "zezez2e", 1, " ", "masculino", 36, 47349383, 64444444, "a",4)));
			
			System.out.println(PacienteBO.novoPaciente(new Paciente(648,"paciente1", "paciente@pciente.com.br",
					"12/01/1997", "paciente123", "paciente123", 1, "c:///", "masculino", "0000005", 1231231231, "historico paciente", 1), true));
			
//			System.out.println(PacienteBO.alterarDadosPaciente
//					(new Paciente(21, "fernando santos", "fernandodossantos001@icloud.com",
//							"12/01/1997", "santosfernando", "santos", 3, "c:\\", "masculino", 34830854, 12312312312l
//							,"teste", 4)));
			
			//System.out.println(PacienteBO.excluirPaciente(21));
			
		//System.out.println(PacienteBO.excluirPaciente(36));
		
		//System.out.println(PacienteBO.pesquisarPaciente(21).getAll()); 
		
//		System.out.println(PacienteBO.alterarDadosPaciente
//				(new Paciente(36, "34", "36@teste.com.br", "12/01/1997", "3636", "3636", 3,
//						"asd", "mas", 333333, "2233233340l, "teste", 3)));
		
		System.out.println(PacienteBO.pesquisarPaciente(36).getAll());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
			
	}

}
