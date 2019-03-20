package br.com.deschateie.main;


import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Consulta;
import br.com.deschateie.beans.Paciente;
import br.com.deschateie.beans.PsiOnline;
import br.com.deschateie.bo.PacienteBO;
import br.com.deschateie.bo.PsiOnlineBO;
import br.com.deschateie.dao.ConsultaDAO;

public class TesteNumero {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		boolean isTrueP = false;
		boolean isTruePsi = false;
		List<Consulta> listaConsultas = new ArrayList<Consulta>();
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		List<PsiOnline> listaPsiOnlines = new ArrayList<PsiOnline>();
		List<List> consulta = new ArrayList<List>();
		
		List<Consulta> listaConsultPaciente = new ArrayList<Consulta>();
		List<Consulta> listaConsultPsiOn = new ArrayList<Consulta>();
		
		ConsultaDAO dao = new ConsultaDAO();
		listaConsultas = dao.pesquisarListaConsulta();
		
		
		
		Paciente paciente;
		PsiOnline psiOnline;
		
		for (Consulta consultas: listaConsultas) {
			
			
			paciente = PacienteBO.pesquisarPaciente(consultas.getCodPaciente());
			
			for(Consulta x : listaConsultPaciente) {
				
				if(x.getCodPaciente() == paciente.getCodPaciente()) {
					isTrueP = true;
					break;
				}
			
			}
			
			if(!isTrueP) {
				listaConsultPaciente.add(consultas);
			}
		
			
			isTrueP = false;
		
			
		
		
		}
		
		for (Consulta consultas: listaConsultas) {
		
			psiOnline = PsiOnlineBO.pesquisarPsicologoOnline(consultas.getCodPsiOnline());
			System.out.println();
			System.out.println("Cod a ser avaliado psi: " + consultas.getCodPsiOnline());
			
			System.out.println();
			for(Consulta x : listaConsultPsiOn) {
				if(x.getCodPsiOnline() == psiOnline.getCodPsicologo()) {
					System.out.println(x.getCodPsiOnline() + " Cod. Psi ON ja existe");
					isTruePsi = true;
					break;
				}
			}
			
			if(!isTruePsi) {
				listaConsultPsiOn.add(consultas);
			}
			
			isTruePsi = false;
			
			
			
			System.out.println();
			System.out.println("==== RESULTADO APOS A VERIFICAÇÃO ====");
			System.out.println();
			System.out.println();
			for(Consulta y : listaConsultPsiOn) {
				System.out.println("PSION: " + y.getCodPsiOnline());
			
			}
			System.out.println();
			
			//Add os obj nas listas
			listaPsiOnlines.add(psiOnline);
			
		}
		

		/* Arrays certos e carregados */
		System.out.println("");
		System.out.println();
		System.out.println();
		System.out.println("================================ ARRAY DE CONSULTA PACIENTE ================================");
		System.out.println();
		for(Consulta obj : listaConsultPaciente) {
			paciente = PacienteBO.pesquisarPaciente(obj.getCodPaciente());
			
			System.out.println();
			System.out.println(paciente.getAll());
			System.out.println();
			
		}
		
		System.out.println("");
		System.out.println();
		System.out.println();
		System.out.println("================================ ARRAY DE CONSULTA PSICOLOGO ================================");
		System.out.println();
		for(Consulta obj : listaConsultPsiOn) {
			psiOnline = PsiOnlineBO.pesquisarPsicologoOnline(obj.getCodPsiOnline());
			
			System.out.println();
			System.out.println(psiOnline.getAll());
			System.out.println();
			
		}
		
		System.out.println("");
		System.out.println();
		System.out.println();
		System.out.println("================================ ARRAY DE PSICOLOGO ================================");
		System.out.println();
		for(PsiOnline obj : listaPsiOnlines) {
			System.out.println();
			System.out.println(obj.getAll());
			System.out.println();
			
		}
		
		System.out.println("");
		System.out.println();
		System.out.println();
		System.out.println("================================ ARRAY DE PACIENTE ================================");
		System.out.println();
		for(Paciente obj : listaPacientes) {
			System.out.println();
			System.out.println(obj.getAll());
			System.out.println();
			
		}
		
		
		consulta.add(listaConsultPaciente);
		consulta.add(listaConsultPsiOn);
		consulta.add(listaPsiOnlines);
		consulta.add(listaPacientes);
		
		
	}

}
