package br.com.deschateie.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Endereco;
import br.com.deschateie.bo.EnderecoBO;
import br.com.deschateie.excecao.Excecao;

public class TesteEndereco {

	public static void main(String[] args) {

		try {
//			List<Endereco> listaEndereco = new ArrayList<Endereco>();
//			listaEndereco = EnderecoBO.pesquisarEnderecoVoluntario("A");
//			
//			for (Endereco endereco : listaEndereco) {
//				System.out.println(endereco.getAll());
//			}
//			
			
			System.out.println(EnderecoBO.pesquisarEnderecoCodVoluntario(24).getAll());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
		

	}

}
