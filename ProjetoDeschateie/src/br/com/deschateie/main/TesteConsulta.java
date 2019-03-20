package br.com.deschateie.main;

import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Consulta;
import br.com.deschateie.beans.Paciente;
import br.com.deschateie.beans.PsiOnline;
import br.com.deschateie.bo.ConsultaBO;
import br.com.deschateie.excecao.Excecao;

public class TesteConsulta {

	public static void main(String[] args) {
		
		try {
			
			List<Consulta> lista = new ArrayList<Consulta>();
			List<Paciente> listaPaciente = new ArrayList<Paciente>();
			List<PsiOnline> listaPsiOnline = new ArrayList<PsiOnline>();
			List<List> listaObjeto = new ArrayList<List>();
			List<List> listaObjeto2 = new ArrayList<List>();
			lista = ConsultaBO.pesquisarConsulta();
			for (Consulta consulta : lista) {
				System.out.println(consulta.getAll());
			}
			
			listaObjeto = ConsultaBO.pesquisarConsultaPaciente();
			listaObjeto2 = ConsultaBO.pesquisarConsultaPsiOnline();
			lista = listaObjeto.get(0);
			listaPaciente = listaObjeto.get(1);
			
			for(Paciente paciente : listaPaciente) {
				System.out.println(paciente.getAll());
			}
			
			lista = listaObjeto2.get(0);
			listaPsiOnline = listaObjeto2.get(1);
			
			for (Consulta consulta : lista) {
				System.out.println(consulta.getAll());
			}
			
			for (PsiOnline psi : listaPsiOnline) {
				System.out.println(psi.getAll());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
		

	}

}
