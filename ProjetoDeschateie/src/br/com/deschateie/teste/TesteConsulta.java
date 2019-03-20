package br.com.deschateie.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.deschateie.beans.Consulta;
import br.com.deschateie.beans.PsiOnline;
import br.com.deschateie.bo.ConsultaBO;
import br.com.deschateie.excecao.Excecao; 
public class TesteConsulta {

	public static void main(String[] args) {
		try {
			List<List> lista = new ArrayList<List>();
			List<PsiOnline> listaPsi = new ArrayList<PsiOnline>();
			List<Consulta> listaConsulta = new ArrayList<Consulta>();
			
			lista = ConsultaBO.pesquisarConsultaPsiOnline();
			listaPsi = lista.get(1);
			Collections.sort(listaPsi);
			for (PsiOnline psi : listaPsi) {
				System.out.println(psi.getNomeUsuario());
			}
			
			listaConsulta = lista.get(0);
			for(Consulta con : listaConsulta) {
				System.out.println(con.getAll());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
