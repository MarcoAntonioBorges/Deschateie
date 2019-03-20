package br.com.deschateie.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Voluntario;
import br.com.deschateie.bo.PacienteBO;
import br.com.deschateie.bo.VoluntarioBO;
import br.com.deschateie.dao.VoluntarioDAO;
import br.com.deschateie.excecao.Excecao;

public class TesteVoluntario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
//			System.out.println(new VoluntarioDAO().consultarVoluntario(27).getAll());
//			System.out.println("----------------------------------------------");
//			System.out.println(VoluntarioBO.consultarVoluntario(28).getAll());
//			
//		System.out.println(new VoluntarioDAO().gravarVoluntario(new Voluntario(1744,
////				"anjosHenry", "henryAnjos@henryanjos.com", "12/01/1985", "HenryAnjos", "anjos", 3, "c:/windwos", "masculino", 1744, "23082342J", 123123123, "psicologia", "noturno", "chato", 272188991)));	
//		
//			System.out.println(VoluntarioBO.novoVoluntario((new Voluntario(1944,
	//				"anjosHenry", "asdfasfd@asfdasf.com", "12/01/1985", "loginss", "anjos", 3, "c:/windwos", "masculino", 1744, "23082342JK", 1231231323, "psicologia", "noturno", "chato", 272188991))));	

	//		System.out.println(VoluntarioBO.excluirVoluntario(28));
//	System.out.println(new VoluntarioDAO().alterarDadosVoluntario(new Voluntario(23,
	//						"anjosHenry", "asdfasfd@asfdasf.com", "12/01/1985", "loginss", "anjos", 3, "c:/windwos", "masculino", "230823K", 1231231323, "psicologia", "noturno", "chato", 272188991)));	

	//	System.out.println(VoluntarioBO.pesquisarVoluntario(23).getAll());
	//	System.out.println("---------------------------------");
	//	System.out.println(PacienteBO.pesquisarPaciente(4).getAll());
		
		System.out.println("================================");
		List<Voluntario> voluntarios = new ArrayList<Voluntario>();
		voluntarios = VoluntarioBO.pesquisarVoluntarioTemporarios();
		for(Voluntario voluntario : voluntarios) {
			System.out.println(voluntario.getAll());
		}
	
	
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
